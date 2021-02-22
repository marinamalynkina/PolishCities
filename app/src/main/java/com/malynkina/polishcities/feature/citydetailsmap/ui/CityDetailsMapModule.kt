package com.malynkina.polishcities.feature.citydetailsmap.ui

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class CityDetailsMapModule {

    @ContributesAndroidInjector(modules = [])
    abstract fun contribute(): CityDetailsMapFragment

}