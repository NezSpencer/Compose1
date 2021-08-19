package com.nezspencer.compose1

import android.os.SystemClock
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val description: String,
    val timeUpdated: Long = SystemClock.elapsedRealtime()
)