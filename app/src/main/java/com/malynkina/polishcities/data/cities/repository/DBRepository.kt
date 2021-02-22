package com.malynkina.polishcities.data.cities.repository

import com.malynkina.polishcities.model.CityModel
import io.reactivex.Completable
import io.reactivex.Flowable

interface DBRepository{
	fun addCity(city: CityModel): Completable
	fun getList(): Flowable<List<CityModel>>
}