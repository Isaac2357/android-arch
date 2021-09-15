package com.example.daggerproject.di.auth

import com.example.daggerproject.di.ActivityScope
import com.example.daggerproject.ui.auth.AuthActivity
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