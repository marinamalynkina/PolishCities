package com.malynkina.polishcities

import com.malynkina.polishcities.model.CityEnum
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class CityEnumUnitTest {
    @Test
    fun cityEnum_getValueByTitle_isCorrect() {
        assertEquals(CityEnum.gdansk, CityEnum.getValueByTitle("Gdańsk"))
    }
}