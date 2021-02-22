package com.malynkina.polishcities.domain.cities.usecase

import com.malynkina.polishcities.core.domain.RxEmptyCompletableUseCase
import com.malynkina.polishcities.domain.cities.repository.CitiesDomainRepository
import io.reactivex.Completable

class InitCitisUseCase (
    private val repository: CitiesDomainRepository
) : RxEmptyCompletableUseCase() {

    override fun buildCompletable(): Completable {
        return Completable.complete()
    }
}