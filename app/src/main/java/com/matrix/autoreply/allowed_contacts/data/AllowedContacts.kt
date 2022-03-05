package com.matrix.autoreply.allowed_contacts.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="allowed_contacts")
data class AllowedContacts(@PrimaryKey @ColumnInfo(name = "name") val name: String)