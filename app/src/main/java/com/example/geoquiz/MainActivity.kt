package com.example.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private val TAG = VM_TAG

    private lateinit var btnTrue: Button
    private lateinit var btnFalse: Button
    private lateinit var btnPrev: Button
    private lateinit var btnNext: Button

    private lateinit var txvQuestion: TextView

    private val questionListModel: QuesionListVM by lazy {
        val viewModelProvider = ViewModelProviders.of(this)
        viewModelProvider.get(QuesionListVM::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate() was called")
        initViews()
        writeUpWidgets()
        questionListModel.question = "whats this?"
    }

    private fun initViews() {
        setContentView(R.layout.activity_main)

        btnTrue = findViewById(R.id.btn_true)
        btnFalse = findViewById(R.id.btn_false)
        btnPrev = findViewById(R.id.btn_prev)
        btnNext = findViewById(R.id.btn_next)

        txvQuestion = findViewById(R.id.txv_question)
//        txvQuestion.setText(questions[currentQuestionIndex].question_id)
        txvQuestion.setText(questionListModel.currentQuestion.question_id)
    }

    private fun writeUpWidgets() {
        btnTrue.setOnClickListener {
            Toast.makeText(this, checkAnswer(true), Toast.LENGTH_SHORT).show()
        }

        btnFalse.setOnClickListener {
            Toast.makeText(this, checkAnswer(false), Toast.LENGTH_SHORT).show()
        }

        btnNext.setOnClickListener {
             txvQuestion.setText(questionListModel.moveToNextQuestion().question_id)
        }

        btnPrev.setOnClickListener {
            txvQuestion.setText(questionListModel.moveToPrevQuestion().question_id)
        }

        txvQuestion.setOnClickListener {
            txvQuestion.setText(questionListModel.moveToNextQuestion().question_id)
        }
    }

    private fun checkAnswer(userInput: Boolean): Int {
        return if (questionListModel.currentQuestion.answer == userInput) {
            R.string.msg_correct
        } else {
            R.string.msg_incorrect
        }
    }

    override fun onStart() {
        super.onStart()

        Log.d(TAG, "onStart() was called")
    }

    override fun onResume() {
        super.onResume()

        Log.d(TAG, "onResume() was called")
    }

    override fun onPause() {
        super.onPause()

        Log.d(TAG, "onPause() was called")
    }

    override fun onStop() {
        super.onStop()

        Log.d(TAG, "onStop() was called")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d(TAG, "onDestroy() was called")
    }
}