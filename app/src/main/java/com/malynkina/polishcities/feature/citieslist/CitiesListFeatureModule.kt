package com.malynkina.polishcities.feature.citieslist

import com.malynkina.polishcities.feature.citieslist.domain.DomainModule
import com.malynkina.polishcities.feature.citieslist.ui.CitiesListModule
import dagger.Module

@Module(
    includes = [
        DomainModule::class,
        CitiesListModule::class
    ]
)
class CitiesListFeatureModule {
}