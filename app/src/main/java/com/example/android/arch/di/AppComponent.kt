package com.example.android.arch.di

import android.app.Application
import com.example.android.arch.di.auth.AuthComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        ViewModelFactoryModule::class,
        SubcomponentsModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface  Builder {

        /**
         * Bind application instance to application component
         * I can use the application instance in all modules related to this
         * component
         */
        @BindsInstance
        fun application(application: Application): Builder

        // Override constructor
        fun build(): AppComponent
    }

    /**
     * Expose Auth SubComponent
     */
    fun authComponent(): AuthComponent.Factory
}