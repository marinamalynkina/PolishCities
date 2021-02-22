package com.malynkina.polishcities.domain.cities.repository

import com.malynkina.polishcities.model.CityModel
import io.reactivex.Completable
import io.reactivex.Flowable

interface CitiesDomainRepository {

	fun addCity(city: CityModel): Completable
	fun getList(): Flowable<List<CityModel>>

}