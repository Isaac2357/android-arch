package com.example.daggerproject.di

import android.app.Application
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.example.daggerproject.R
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import com.example.daggerproject.util.Constants.Companion.BASE_URL as JSON_PLACEHOLDER_URL

/**
 * Application level dependencies
 * Retrofit Instance, Glide Instance
 */

@Module
object AppModule {
    /**
     * Declares a dependency
     */
    @Singleton
    @Provides
    fun provideRequestOptions(): RequestOptions = RequestOptions
        .placeholderOf(R.drawable.white_background)
        .error(R.drawable.white_background)

    /**
     * RequestOptions referencing from provideRequestOptions
     * Application referencing from AppComponent
     */
    @Singleton
    @Provides
    fun provideGlideInstance(
        application: Application,
        requestOptions: RequestOptions
    ): RequestManager {
        return Glide.with(application)
            .setDefaultRequestOptions(requestOptions)
    }

    /**
     * Application referencing from AppComponent
     */
    @Singleton
    @Provides
    fun provideAppLogo(application: Application): Drawable {
        return ContextCompat.getDrawable(application, R.drawable.logo)!!
    }

    /**
     * Retrofit object
     */
    @Singleton
    @Provides
    fun provideRetrofitInstance(): Retrofit = Retrofit.Builder()
        .baseUrl(JSON_PLACEHOLDER_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

}