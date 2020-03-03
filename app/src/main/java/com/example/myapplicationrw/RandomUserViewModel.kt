package com.example.myapplicationrw

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.myapplicationrw.data.randomUser

class RandomUserViewModel(application: Application) : AndroidViewModel(application) {

    private var randomUserDao : RandomUserDao

    init {
        randomUserDao = RandomUserDao.getInstance(this.getApplication())
    }

    fun addUsers() {
        randomUserDao.addUsers()
    }

    fun getUsers(): MutableLiveData<List<randomUser>> {
        return randomUserDao.getUsers()
    }
}