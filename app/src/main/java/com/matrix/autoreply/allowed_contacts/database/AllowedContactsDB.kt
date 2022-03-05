package com.matrix.autoreply.allowed_contacts.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.matrix.autoreply.allowed_contacts.dao.AllowedContactsDao
import com.matrix.autoreply.allowed_contacts.data.AllowedContacts
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Database(entities = [AllowedContacts::class], version = 1, exportSchema = false)
abstract class AllowedContactsDB : RoomDatabase(){

    abstract fun allowedContactsDao() : AllowedContactsDao

    companion object {

        @Volatile
        private var INSTANCE : AllowedContactsDB? = null

        fun getDatabase(context: Context, scope: CoroutineScope): AllowedContactsDB{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AllowedContactsDB::class.java,
                    "allowed_contacts_database"
                ).build()

                INSTANCE = instance

                // return instance
                instance
            }
        }
    }
}