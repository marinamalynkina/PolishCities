package com.malynkina.polishcities.feature.citieswithdetails.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.google.common.base.Optional
import com.malynkina.polishcities.feature.citieslist.ui.CitiesListNavigation
import dagger.BindsOptionalOf
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
abstract class CitiesWithDetailsModule {

    @BindsOptionalOf
    abstract fun optionalNavigation(): CitiesListNavigation

    @ContributesAndroidInjector(modules = [ProvideModule::class])
    abstract fun contribute(): CitiesWithDetailsFragment

    @Module
    class ProvideModule {

        @Provides
        fun inject(
            target: CitiesWithDetailsFragment,
            factory: ViewModelProvider.Factory
        ) = ViewModelProviders.of(target, factory).get(CitiesWithDetailsViewModel::class.java)

        @Provides
        @IntoMap
        @ClassKey(CitiesWithDetailsViewModel::class)
        fun provide(
            navigation: Optional<CitiesListNavigation>
        ): ViewModel =
            CitiesWithDetailsViewModel(
                navigation.orNull()
            )
    }
}