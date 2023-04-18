package com.example.allaboutroomdbmigration


class MainRepository(private val dao: StudentDao) {
    suspend fun addStudent(student: Student) {
        return dao.insertStudent(student)
    }


}