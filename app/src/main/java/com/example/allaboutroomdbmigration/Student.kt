package com.example.allaboutroomdbmigration

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.RenameColumn

@Entity(tableName = "student_table")
data class Student(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "student_id")
    val id: Int,

    @ColumnInfo(name = "user_name")
    val name: String,


    @ColumnInfo(name = "user_email")
    val email: String?
)