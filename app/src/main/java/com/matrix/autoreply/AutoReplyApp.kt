package com.matrix.autoreply

import android.app.Application
import com.matrix.autoreply.allowed_contacts.database.AllowedContactsDB
import com.matrix.autoreply.allowed_contacts.repository.AllowedContactsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class AutoReplyApp : Application() {

    // No need to cancel this scope as it'll be torn down with the process
    private val applicationScope = CoroutineScope(SupervisorJob())

    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    private val database by lazy { AllowedContactsDB.getDatabase(this,applicationScope) }
    val repository by lazy { AllowedContactsRepository(database.allowedContactsDao()) }
}