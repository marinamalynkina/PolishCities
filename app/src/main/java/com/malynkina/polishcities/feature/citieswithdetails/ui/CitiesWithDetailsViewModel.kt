package com.malynkina.polishcities.feature.citieswithdetails.ui

import androidx.lifecycle.ViewModel
import com.malynkina.polishcities.feature.citieslist.ui.CitiesListNavigation
import com.malynkina.polishcities.model.CityModel

class CitiesWithDetailsViewModel(
    private val navigation: CitiesListNavigation?,
) : ViewModel() {

    fun showDetails(cityModel: CityModel) {
        navigation?.showCityDetails(cityModel)
    }

    fun clear() {
        onCleared()
    }
}