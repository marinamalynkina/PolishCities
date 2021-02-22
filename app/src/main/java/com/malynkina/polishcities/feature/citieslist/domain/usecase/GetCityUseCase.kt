package com.malynkina.polishcities.feature.citieslist.domain.usecase

import com.malynkina.polishcities.core.domain.RxEmptyFlowableUseCase
import com.malynkina.polishcities.domain.cities.repository.CitiesDomainRepository
import com.malynkina.polishcities.model.CityModel
import io.reactivex.Flowable

class GetCityUseCase (
    private val repository: CitiesDomainRepository
) : RxEmptyFlowableUseCase<List<CityModel>>() {

    override fun buildFlowable(): Flowable<List<CityModel>> {
        return repository.getList()
//            .doOnSubscribe {
//                repository.
//            }
    }
}