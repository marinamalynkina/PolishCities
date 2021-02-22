package com.malynkina.polishcities.feature.citieswithdetails

import com.malynkina.polishcities.feature.citieslist.domain.DomainModule
import com.malynkina.polishcities.feature.citieswithdetails.ui.CitiesWithDetailsModule
import dagger.Module

@Module(
    includes = [
        DomainModule::class,
        CitiesWithDetailsModule::class
    ]
)
class CitiesWithDetailsFeatureModule {
}