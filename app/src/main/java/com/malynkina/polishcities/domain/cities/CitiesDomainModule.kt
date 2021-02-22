package com.malynkina.polishcities.domain.cities

import com.malynkina.polishcities.data.cities.repository.DBRepository
import com.malynkina.polishcities.domain.cities.interactor.CityGeneratorInteractor
import com.malynkina.polishcities.domain.cities.repository.CitiesDomainRepository
import com.malynkina.polishcities.domain.cities.repository.CitiesDomainRepositoryImpl
import com.malynkina.polishcities.domain.cities.usecase.CityGeneratorUseCase
import com.malynkina.polishcities.domain.cities.usecase.InitCitisUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CitiesDomainModule {

    @Singleton
    @Provides
    fun provideCitiesDomainRepository(
        db: DBRepository
    ): CitiesDomainRepository =
        CitiesDomainRepositoryImpl(
            db
        )

    @Provides
    fun provideCityGeneratorInteractor(
        repository: CitiesDomainRepository
    ): CityGeneratorInteractor =
        CityGeneratorInteractor(
            generateCities = CityGeneratorUseCase(
                citiesColorList = listOf("Yellow", "Green", "Blue", "Red", "Black", "White"),
                repository = repository
            ),
            initCities = InitCitisUseCase(repository)
        )
}