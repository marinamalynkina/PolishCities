package com.malynkina.polishcities.feature.citieslist.util

import com.malynkina.polishcities.model.CityModel
import java.util.*

class CitySortedList() {

    private val map = sortedMapOf<String, LinkedList<CityModel>>()
    private val lastChanges: MutableList<Pair<Int, Int>> = mutableListOf<Pair<Int, Int>>()

    val size: Int
        get() {
            var size = 0
            map.keys.forEach { size += map.get(it)!!.size }
            return size
        }


    /**
     * return position in list
     */
    fun add(city: CityModel, addInChanges: Boolean = true): Int {
        if (map.containsKey(city.name)) {
            map.get(city.name)?.add(city)
        }else {
            val list = LinkedList<CityModel>()
            list.add(city)
            map.put(city.name, list)
        }
        val index = getSizeListToLast(city.name)-1
        lastChanges.add(Pair(index, 1))
        return index
    }

    fun addAll(list: List<CityModel>) {
        val positionList = mutableListOf<Int>()
        list.forEach {
            positionList.add(add(it, false))
        }
        
        val archivedPositionList = mutableListOf<Pair<Int, Int>>()
        var countOfRange = 0
        var firstPosition = 0
        for (i in 0..positionList.size-1) {
            if (countOfRange == 0) {
                firstPosition = positionList[i]
                countOfRange ++
            }
            if (i+1 < positionList.size) {
                if (positionList[i] != positionList[i + 1] + 1) {
                    archivedPositionList.add(Pair(firstPosition, countOfRange))
                    countOfRange = 0
                } else countOfRange++
            } else {
                if (countOfRange > 0)
                    archivedPositionList.add(Pair(firstPosition, countOfRange))
            }
        }

        lastChanges.addAll(archivedPositionList)
    }


    private fun getSizeListToLast(key: String): Int {
        var size = 0
        map.keys.forEach {
            if (it != key)
                size += map.get(it)!!.size
            else return size
        }
        return size
    }

}