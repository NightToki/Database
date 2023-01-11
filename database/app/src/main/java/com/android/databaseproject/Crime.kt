package com.android.databaseproject

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Crime(
    @PrimaryKey val id: UUID=UUID.randomUUID(),
    val title: String,
    val date: Date,
    val isSolved: Boolean
)
