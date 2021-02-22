package com.malynkina.polishcities.data.cities.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.malynkina.polishcities.model.CityModel
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
interface CitiesDAO {

//    @WorkerThread
    @Insert//(onConflict = OnConflictStrategy.REPLACE)
    fun insert(city: CityModel): Completable

//    @WorkerThread
    @Query("SELECT * FROM cities ORDER BY cities.name")
    fun getAll(): Flowable<List<CityModel>>
}