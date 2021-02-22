package com.malynkina.polishcities.feature.citieslist.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.malynkina.polishcities.feature.citieslist.domain.interactor.CitiesInteractor
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
abstract class CitiesListModule {

    @ContributesAndroidInjector(modules = [ProvideModule::class])
    abstract fun contribute(): CitiesListFragment

    @Module
    class ProvideModule {

        @Provides
        fun inject(
            target: CitiesListFragment,
            factory: ViewModelProvider.Factory
        ) = ViewModelProviders.of(target, factory).get(CitiesListViewModel::class.java)

        @Provides
        @IntoMap
        @ClassKey(CitiesListViewModel::class)
        fun provide(
            interactor: CitiesInteractor
        ): ViewModel =
            CitiesListViewModel(
                interactor
            )
    }
}