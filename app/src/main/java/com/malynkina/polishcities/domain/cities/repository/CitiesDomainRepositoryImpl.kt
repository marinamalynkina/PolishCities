package com.malynkina.polishcities.domain.cities.repository

import android.util.Log
import com.malynkina.polishcities.data.cities.repository.DBRepository
import com.malynkina.polishcities.model.CityModel
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.subjects.PublishSubject

internal class CitiesDomainRepositoryImpl(
	private val dbRepository: DBRepository
) : CitiesDomainRepository {

	private var cachedSubj: PublishSubject<List<CityModel>>? = PublishSubject.create()
	@Volatile private var getCardsStarted = false
	@Volatile private var loadedFromDb = false

	private fun getSubject(): PublishSubject<List<CityModel>>{
		if (cachedSubj == null) cachedSubj = PublishSubject.create()
		return cachedSubj!!
	}

	override fun addCity(city: CityModel): Completable {
		return dbRepository.addCity(city)
			.doOnComplete {
				getSubject().onNext(listOf(city))
			}
			.doOnError {
				Log.i("cities", "addCity error ${it.message}")
				it.printStackTrace()
			}
	}

	override fun getList(): Flowable<List<CityModel>> {
		return dbRepository.getList()
	}


}