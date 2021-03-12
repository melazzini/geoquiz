package com.example.geoquiz

import android.util.Log
import androidx.lifecycle.ViewModel

private const val TAG = "QuizViewModel"

class QuizViewModel: ViewModel() {
    init {
        Log.d(TAG,"init: QuizViewModel instance created!")
    }

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG,"onCleared(): QuizViewModel instance about to be destroyed!")
    }

}