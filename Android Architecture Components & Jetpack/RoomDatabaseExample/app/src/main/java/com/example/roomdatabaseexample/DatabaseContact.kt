package com.example.roomdatabaseexample

import android.content.Context
import androidx.room.*
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

/*
* It is a Database class that contains set of methods to access each table
* The best practice is to follow the SINGLETON approach, while creating database Instances.
* SINGLETON means there can be only one DATABASE instance which is accessible to any thread
* */

@Database(entities = [ContactEntity::class], version = 2)
@TypeConverters(Convertor::class)
abstract class DatabaseContact : RoomDatabase() {
    /*
    * synchronized() block is used to achieve locking while creating database instance by multiple threads
    * so that only one of those threads can create the database instance
    * */
    companion object {
        // MIGRATING DATABASE TO NEXT VERSION
        // Like, here we're adding one column
        val migration_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE contact ADD COLUMN isActive INTEGER NOT NULL DEFAULT(1)")
            }
        }

        
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
                    )
                        .addMigrations(migration_1_2)
                        .build()
                }
            }
            return INSTANCE!!

        }
    }


    // Internal IMPLEMENTATION for tables is provided by Room Database only
    // Methods for each table
    abstract fun contactDao(): ContactDao
}


