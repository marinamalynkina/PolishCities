package com.malynkina.polishcities.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "cities")
data class CityModel(
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null,
    val name: String,
    val color: String,
    val createdTime: Long = System.currentTimeMillis()
): Parcelable {
}