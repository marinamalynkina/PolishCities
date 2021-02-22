package com.malynkina.polishcities.di

import com.malynkina.polishcities.feature.citieslist.CitiesListFeatureModule
import com.malynkina.polishcities.feature.citieswithdetails.CitiesWithDetailsFeatureModule
import com.malynkina.polishcities.feature.citydetailsmap.CityDetailsMapFeatureModule
import dagger.Module

@Module(
    includes = [
        CitiesListFeatureModule::class,
        CityDetailsMapFeatureModule::class,
        CitiesWithDetailsFeatureModule::class
    ]
)
class FeatureModule