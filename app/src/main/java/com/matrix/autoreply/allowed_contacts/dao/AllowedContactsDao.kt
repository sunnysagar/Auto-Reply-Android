package com.matrix.autoreply.allowed_contacts.dao

import androidx.room.*
import com.matrix.autoreply.allowed_contacts.data.AllowedContacts
import kotlinx.coroutines.flow.Flow

@Dao
interface AllowedContactsDao {

    @Query("SELECT * FROM allowed_contacts ORDER BY name")
    fun getContacts(): Flow<MutableList<AllowedContacts>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(allowedContacts: AllowedContacts)

    @Delete
    suspend fun delete(allowedContacts: AllowedContacts)
}