package com.malynkina.polishcities.activity

import android.util.Log
import androidx.lifecycle.ViewModel
import com.malynkina.polishcities.domain.cities.interactor.CityGeneratorInteractor

class AppActivityViewModel(
	private val generator: CityGeneratorInteractor,
): ViewModel() {

	init {

	}

	fun startGenerator() {
		generator.generateCities(
			onComplete = {
				Log.i("polishcities", "startGenerator onComplete")
			},
			onError = {
				Log.i("polishcities", "startGenerator error: ${it.message}")
			}
		)
	}

	fun stopGenerator() {
		generator.generateCities.cancel()
	}

	fun clear() {
		onCleared()
	}
}