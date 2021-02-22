package com.malynkina.polishcities.di

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.malynkina.polishcities.activity.ActivityModule
import dagger.Module
import dagger.Provides
import dagger.android.support.DaggerApplication
import javax.inject.Provider

@Module(
    includes = [
        ActivityModule::class,
        DataModule::class,
        FeatureModule::class,
        NavigationModule::class
    ]
)
class AppModule {

    @Provides
    fun provideContext(application: DaggerApplication): Context = application

    @Provides
    fun provideViewModelProviderFactory(
        providers: Map<Class<*>, @JvmSuppressWildcards Provider<ViewModel>>
    ): ViewModelProvider.Factory {
        return object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return requireNotNull(providers[modelClass]).get() as T
            }
        }
    }

}
