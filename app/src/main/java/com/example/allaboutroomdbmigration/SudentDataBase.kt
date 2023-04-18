package com.example.allaboutroomdbmigration

import android.content.Context
import androidx.room.*
import androidx.room.migration.AutoMigrationSpec

@Database(
    entities = [Student::class],
    version = 2,
    autoMigrations = [
        AutoMigration(1, 2, spec =StudentDataBase.migration1to2::class)
    ]

)
abstract class StudentDataBase : RoomDatabase() {
    abstract val studentDao: StudentDao

    @RenameColumn("student_table", "student_email", "user_email")
    @RenameColumn("student_table", "student_name", "user_name")
    class migration1to2 : AutoMigrationSpec


    companion object {
        @Volatile
        private var INSTANCE: StudentDataBase? = null
        fun getInstance(context: Context): StudentDataBase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance =
                        Room.databaseBuilder(
                            context = context,
                            StudentDataBase::class.java, "student_database_build"
                        )
                            .build()
                    INSTANCE = instance
                }
                return instance
            }

        }
    }
}