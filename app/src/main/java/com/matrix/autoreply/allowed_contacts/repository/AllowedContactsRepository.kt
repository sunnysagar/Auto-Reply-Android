package com.matrix.autoreply.allowed_contacts.repository

import androidx.annotation.WorkerThread
import com.matrix.autoreply.allowed_contacts.dao.AllowedContactsDao
import com.matrix.autoreply.allowed_contacts.data.AllowedContacts
import kotlinx.coroutines.flow.Flow


class AllowedContactsRepository(private val allowedContactsDao: AllowedContactsDao) {

    val allContacts: Flow<MutableList<AllowedContacts>> = allowedContactsDao.getContacts()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(allowedContacts: AllowedContacts){
        allowedContactsDao.insert(allowedContacts)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun delete(allowedContacts: AllowedContacts){
        allowedContactsDao.delete(allowedContacts)
    }

}