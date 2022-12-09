package com.example.myapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Task::class],
    version=1,
    exportSchema = false
)

abstract class TaskDataBase :RoomDatabase(){
    abstract val taskdao:TaskDao

    companion object{
        @Volatile
        private var INSTANCE: TaskDataBase? = null

        fun getDB(context:Context):TaskDataBase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }

            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TaskDataBase::class.java,
                    "TaskDB"
                ).build()

                INSTANCE = instance
                return instance
            }

        }
    }
}