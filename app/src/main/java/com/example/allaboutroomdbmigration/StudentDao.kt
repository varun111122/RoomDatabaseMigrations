package com.example.allaboutroomdbmigration

import androidx.room.Insert
import androidx.room.OnConflictStrategy

@androidx.room.Dao
interface StudentDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertStudent(student: Student)
}