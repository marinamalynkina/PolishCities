package com.malynkina.polishcities.feature.citieslist.ui

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.malynkina.polishcities.feature.citieslist.domain.interactor.CitiesInteractor
import com.malynkina.polishcities.model.CityModel

class CitiesListViewModel(
    private val interactor: CitiesInteractor
) : ViewModel() {

    // priority queue
    @RequiresApi(Build.VERSION_CODES.N)
    val cities: MutableLiveData<List<CityModel>> = MutableLiveData(listOf<CityModel>())

    fun getCities() {
        interactor.getCitiesUseCase(
            onComplete = {
                Log.i("cities" ,"getCitiesUseCase onComplete")
            },
            onNext = {
                Log.i("cities" ,"getCitiesUseCase onNext")
                cities.postValue(it)
            },
            onError = {
                Log.i("cities" ,"getCitiesUseCase onError ${it.message}" )
                it.printStackTrace()
            }
        )
    }

    fun clear() {
        interactor.getCitiesUseCase.cancel()
        onCleared()
    }
}