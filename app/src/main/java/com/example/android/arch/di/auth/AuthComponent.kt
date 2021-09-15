package com.example.android.arch.di.auth

import com.example.android.arch.di.ActivityScope
import com.example.android.arch.ui.auth.AuthActivity
import dagger.Subcomponent

@ActivityScope
@Subcomponent(
    modules = [
        AuthModule::class,
        AuthViewModelModule::class
    ]
)
interface AuthComponent {

    /**
     * SubComponent Factory
     */
    @Subcomponent.Factory
    interface Factory {
        fun create(): AuthComponent
    }

    fun inject(activity: AuthActivity)

}