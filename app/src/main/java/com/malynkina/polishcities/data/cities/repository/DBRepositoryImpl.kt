package com.malynkina.polishcities.data.cities.repository

import com.malynkina.polishcities.data.cities.db.CitiesDAO
import com.malynkina.polishcities.model.CityModel
import io.reactivex.Completable
import io.reactivex.Flowable

internal class DBRepositoryImpl(
	private val dao: CitiesDAO
) : DBRepository {

	override fun addCity(city: CityModel): Completable {
		return dao.insert(city)
	}

	override fun getList(): Flowable<List<CityModel>> {
		return dao.getAll()
	}
}