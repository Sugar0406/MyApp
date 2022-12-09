package com.example.myapp.data

import androidx.room.ColumnInfo
import androidx.room.Database
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import java.security.PublicKey
import java.sql.Date

//@Database(entities = [Task::class], version = 1)
//@TypeConverters(Converter::class)

@Entity(tableName = "taskData")
data class Task(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="task_id")
    val task_id: Int,

    @ColumnInfo(name = "task_name")
    val task_name: String,
//    private val task_daedline: Date?,

    @ColumnInfo(name = "describe")
    val describe: String,

    )

//package com.example.myapp
//
//import androidx.room.*
//import java.sql.Date
//
//
//class Converters {
//    @TypeConverter
//    fun fromTimestamp(value: Long?): Date? {
//        return value?.let { Date(it) }
//    }
//
//    @TypeConverter
//    fun dateToTimestamp(date: Date?): Long? {
//        return date?.time?.toLong()
//    }
//}
//
//@Database(entities = [DataBase::class], version = 1)
//@TypeConverters(Converters::class)
//abstract class AppDatabase : RoomDatabase() {
//    abstract fun dbDao() : DataBaseDao
//}
//
//@Entity
//data class DataBase(
//    @PrimaryKey(autoGenerate = true) val task_id: Int,
//    @ColumnInfo(name = "task_name") val taskName: String,
//    @ColumnInfo(name = "Deadline") val deadline: Date?,
//    @ColumnInfo(name = "Describe") val describe: String
//)