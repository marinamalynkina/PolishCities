package com.malynkina.polishcities.di

import androidx.core.os.bundleOf
import com.malynkina.polishcities.Navigator
import com.malynkina.polishcities.R
import com.malynkina.polishcities.feature.citieslist.ui.CitiesListNavigation
import com.malynkina.polishcities.model.CityModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class NavigationModule {

	@Singleton
	@Provides
	fun provideNavigator() = Navigator()

	@Provides
	fun provideSplashNavigation(
		navigator: Navigator
	): CitiesListNavigation = object : CitiesListNavigation {
		override fun showCityDetails(city: CityModel) {
			navigator.navigate(
				R.id.action_showdetails, bundleOf(
					"city" to city
				)
			)
		}

	}
}