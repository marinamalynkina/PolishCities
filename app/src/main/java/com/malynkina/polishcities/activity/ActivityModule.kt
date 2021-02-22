package com.malynkina.polishcities.activity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.malynkina.polishcities.domain.cities.interactor.CityGeneratorInteractor
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [ProvideModule::class])
    internal abstract fun contributeAppActivity(): AppActivity

    @Module
    class ProvideModule {

        @Provides
        fun inject(
            target: AppActivity,
            factory: ViewModelProvider.Factory
        ) = ViewModelProviders.of(target, factory).get(AppActivityViewModel::class.java)

        @Provides
        @IntoMap
        @ClassKey(AppActivityViewModel::class)
        fun provide(
            generator: CityGeneratorInteractor
        ): ViewModel =
            AppActivityViewModel(generator)
    }
}