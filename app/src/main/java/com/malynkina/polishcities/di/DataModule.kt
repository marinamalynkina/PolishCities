package com.malynkina.polishcities.di

import android.content.Context
import androidx.room.Room
import com.malynkina.polishcitie.db.PolishCitiesDatabase
import com.malynkina.polishcities.data.cities.CitiesDataModule
import com.malynkina.polishcities.data.cities.db.CitiesDAO
import com.malynkina.polishcities.domain.cities.CitiesDomainModule
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(
    includes = [
        CitiesDataModule::class,
        CitiesDomainModule::class
    ]
)
class DataModule {

    @Singleton
    @Provides
    fun provideRoomDatabase(
        context: Context
    ): PolishCitiesDatabase =
        Room.databaseBuilder(
            context,
            PolishCitiesDatabase::class.java, "polishcities_database"
        ).build()

    @Provides
    fun providePolishCitiesDAO(
        db: PolishCitiesDatabase
    ): CitiesDAO = db.citiesDAO()
}