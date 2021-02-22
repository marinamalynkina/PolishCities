package com.malynkina.polishcities.domain.cities.usecase

import com.malynkina.polishcities.core.domain.RxEmptyCompletableUseCase
import com.malynkina.polishcities.domain.cities.repository.CitiesDomainRepository
import com.malynkina.polishcities.model.CityEnum
import com.malynkina.polishcities.model.CityModel
import io.reactivex.Completable
import io.reactivex.Flowable
import java.util.concurrent.TimeUnit

class CityGeneratorUseCase (
    private val citiesColorList: List<String>,
    private val repository: CitiesDomainRepository
) : RxEmptyCompletableUseCase() {

    override fun buildCompletable(): Completable {
        return Flowable.interval(5, TimeUnit.SECONDS)
            .flatMap {
                Flowable.just(
                    CityModel(
                        name = CityEnum.values().random().title,
                        color = citiesColorList.random()
                    )
                )
            }
            .flatMapCompletable {
                repository.addCity(it)
            }
    }
}