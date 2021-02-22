package com.malynkina.polishcities.feature.citieslist.domain

import com.malynkina.polishcities.domain.cities.repository.CitiesDomainRepository
import com.malynkina.polishcities.feature.citieslist.domain.interactor.CitiesInteractor
import com.malynkina.polishcities.feature.citieslist.domain.usecase.GetCityUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideCitiesInteractor(
        repository: CitiesDomainRepository
    ): CitiesInteractor =
        CitiesInteractor(
            getCitiesUseCase = GetCityUseCase(
                repository
            )
        )
}