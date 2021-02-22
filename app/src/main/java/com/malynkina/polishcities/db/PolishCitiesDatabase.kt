package com.malynkina.polishcitie.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.malynkina.polishcities.data.cities.db.CitiesDAO
import com.malynkina.polishcities.model.CityModel

@Database(
    entities = [
        CityModel::class
    ],
    version = 1,
    exportSchema = false
)
abstract class PolishCitiesDatabase: RoomDatabase() {

    abstract fun citiesDAO() : CitiesDAO

}