package com.example.allaboutroomdbmigration

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel(private val repo: MainRepository) : ViewModel() {

    val inputName = MutableLiveData<String>()
    val inputEmail = MutableLiveData<String>()

    fun insertStudent() {
        Log.d("varun", "insertStudent: ${inputName.value}")
        viewModelScope.launch {
            repo.addStudent(Student( 0,inputName.value.toString(), inputEmail.value.toString()))
            inputName.value = ""
            inputEmail.value = ""
        }

    }

}