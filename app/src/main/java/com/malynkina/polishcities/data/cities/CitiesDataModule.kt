package com.malynkina.polishcities.data.cities

import com.malynkina.polishcities.data.cities.db.CitiesDAO
import com.malynkina.polishcities.data.cities.repository.DBRepository
import com.malynkina.polishcities.data.cities.repository.DBRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class CitiesDataModule {

    @Provides
    fun provideDbRepository(
        dao: CitiesDAO
    ) : DBRepository = DBRepositoryImpl(dao)

}