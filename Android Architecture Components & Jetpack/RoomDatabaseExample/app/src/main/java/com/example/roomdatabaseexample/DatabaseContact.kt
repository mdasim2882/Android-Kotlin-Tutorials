package com.example.roomdatabaseexample

import android.content.Context
import androidx.room.*

/*
* It is a Database class that contains set of methods to access each table
* The best practice is to follow the SINGLETON approach, while creating database Instances.
* SINGLETON means there can be only one DATABASE instance which is accessible to any thread
* */

@Database(entities = [ContactEntity::class], version = 1)
@TypeConverters(Convertor::class)
abstract class DatabaseContact : RoomDatabase() {
    /*
    * synchronized() block is used to achieve locking while creating database instance by multiple threads
    * so that only one of those threads can create the database instance
    * */
    companion object {
        // @Volatile is used here so that every thread knows that it values has been changed
        @Volatile
        private var INSTANCE: DatabaseContact? = null

        fun getDatabase(context: Context): DatabaseContact {

            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        DatabaseContact::class.java,
                        "contactDB"
                    ).build()
                }
            }
            return INSTANCE!!

        }
    }


    // Internal IMPLEMENTATION for tables is provided by Room Database only
    // Methods for each table
    abstract fun contactDao(): ContactDao
}


