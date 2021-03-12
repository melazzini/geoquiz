package com.example.geoquiz

import android.util.Log
import androidx.lifecycle.ViewModel

private const val TAG = "QuestionListVM"
const val VM_TAG = "VM_TAG"

class QuesionListVM : ViewModel() {
    var question: String = ""

    private val questions = arrayOf(
        Question(R.string.question_sun, false),
        Question(R.string.question_alphaCentaur, true),
        Question(R.string.question_earth, false),
        Question(R.string.question_derivative, false),
        Question(R.string.question_earth_moon, true)
    )

    private var currentIndex = 0

    var currentQuestion: Question = questions[currentIndex]

    init {
        Log.d(VM_TAG, "QuestionListVM is being created!")
    }

    override fun onCleared() {
        super.onCleared()
        Log.d(VM_TAG, "QuestionListVM is being destroyed!")
    }

    fun moveToNextQuestion(): Question {
//        Log.d(TAG,"updating question index", Exception())

        currentIndex = if (currentIndex < questions.size - 1) {
            currentIndex + 1
        } else {
            0
        }
        currentQuestion = questions[currentIndex]
        return currentQuestion
    }

    fun moveToPrevQuestion(): Question {
        currentIndex = if (currentIndex > 0) {
            currentIndex - 1
        } else {
            questions.size - 1
        }
        currentQuestion = questions[currentIndex]
        return currentQuestion
    }
}