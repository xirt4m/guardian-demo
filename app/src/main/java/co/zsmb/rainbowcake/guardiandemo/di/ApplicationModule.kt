package co.zsmb.rainbowcake.guardiandemo.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
class ApplicationModule {

    @Provides
    @Singleton
    fun provideApplicationContext(application: Application): Context =
        application.applicationContext

}
