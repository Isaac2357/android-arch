package com.example.daggerproject.ui.auth

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.RequestManager
import com.example.daggerproject.BaseApplication
import com.example.daggerproject.R
import com.example.daggerproject.databinding.ActivityAuthBinding
import com.example.daggerproject.di.auth.AuthComponent
import com.example.daggerproject.models.User
import com.example.daggerproject.network.Resource
import com.example.daggerproject.util.Status
import javax.inject.Inject

/**
 * To use ContributesAndroidInjector we need to extend the activity from
 * DaggerAppCompatActivity
 */
class AuthActivity : AppCompatActivity() {

    /**
     * Reference to Auth Graph
     */
    private lateinit var authComponent: AuthComponent

    /**
     * Dependency Injections
     */
    @Inject
    lateinit var logo: Drawable
    @Inject
    lateinit var requestManager: RequestManager
    @Inject
    lateinit var viewModelProviderFactory: ViewModelProvider.Factory

    /**
     * View Model
     */
    private  val authViewModel: AuthViewModel by viewModels { viewModelProviderFactory }
    private val loginObserver: Observer<Resource<User>> = Observer { resource ->

        when (resource.status) {
            Status.SUCCESS -> {
                toast("Login Succeed")
            }
            Status.ERROR -> {
                toast("Login failed")
            }
            Status.LOADING -> { }
        }

    }

    /**
     * Binding
     */
    private lateinit var binding: ActivityAuthBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)
        authComponent = (application as BaseApplication).appComponent.authComponent().create()
        authComponent.inject(this)
        initLogo()
        initViews()
    }

    private fun initLogo() {
        requestManager.load(logo)
            .into(findViewById(R.id.login_logo))
    }

    private fun initViews() {

        binding.loginButton.setOnClickListener {
            val userId = binding.userIdInput.text.toString().toIntOrNull()
            if (userId != null) {
                authViewModel.login(userId).observe(this, loginObserver)
            } else {
                // TODO Say to the user that empty values are not allowed
            }
        }
    }

    private fun toast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT)
            .show()
    }

}