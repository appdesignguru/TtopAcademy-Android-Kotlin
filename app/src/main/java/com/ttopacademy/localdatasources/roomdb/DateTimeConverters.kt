package com.ttopacademy.localdatasources.roomdb

import androidx.room.TypeConverter
import java.util.*

/** DateTime converter class for Room database.  */
object DateTimeConverters {

    /** Converts timestamp from Long to Date.  */
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return if (value == null) null else Date(value)
    }

    /** Converts timestamp from Date to Long.  */
    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }
}