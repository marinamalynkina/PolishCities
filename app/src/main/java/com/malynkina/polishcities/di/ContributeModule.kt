package com.malynkina.polishcities.di

import com.malynkina.polishcities.Application
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ContributeModule {

    @ContributesAndroidInjector
    abstract fun contribute(): Application

}
