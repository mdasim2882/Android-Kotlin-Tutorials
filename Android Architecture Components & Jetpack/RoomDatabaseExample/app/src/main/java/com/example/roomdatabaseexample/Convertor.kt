package com.example.roomdatabaseexample

import androidx.room.TypeConverter
import java.util.*

/*
* Since, Room supports only limited data types for columns, therefore we use
* convertors to include additional DATA TYPES for columns
* Convertors are called when the data is stored and fetched
 */
class Convertor {

    @TypeConverter
    fun fromDateToLong(value: Date)  = value.time

    @TypeConverter
    fun fromLongToDate(value: Long)  = Date(value)
}