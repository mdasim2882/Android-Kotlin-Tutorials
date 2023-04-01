package com.example.roomdatabaseexample

import android.database.sqlite.SQLiteQuery
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.room.Room
import androidx.room.Update
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var database: DatabaseContact
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val contact1 = ContactEntity(0, "John", "9581111112", Date())
        val contact2 = ContactEntity(0, "Jason", "9581113312",Date())

        // Now, both database and database2 will point to same reference "SatabaseContact_Impl@9991"
        // due to synchronize() block with locking mechanism
        database = DatabaseContact.getDatabase(this)
        val database2 = DatabaseContact.getDatabase(this)


        GlobalScope.launch {
            // Calling UPDATE query
            database.contactDao().updateName(2,"Tim Cook")
            // Calling INSERT query
            database.contactDao().insertContact(contact1)
            database2.contactDao().insertContact(contact2)
        }
    }

    fun doThis(view: View) {
        database.contactDao().getContact().observe(this, Observer {

            Log.d("Testing",it.toString())

        })
    }
}