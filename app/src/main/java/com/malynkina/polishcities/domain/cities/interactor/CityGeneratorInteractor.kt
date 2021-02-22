package com.malynkina.polishcities.domain.cities.interactor

import com.malynkina.polishcities.domain.cities.usecase.CityGeneratorUseCase
import com.malynkina.polishcities.domain.cities.usecase.InitCitisUseCase


class CityGeneratorInteractor(
    val generateCities: CityGeneratorUseCase,
    val initCities: InitCitisUseCase
) {
}