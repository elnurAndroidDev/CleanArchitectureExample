package com.isayevapps.cleanarchitectureexample.presentation

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.isayevapps.cleanarchitectureexample.R
import com.isayevapps.cleanarchitectureexample.data.repository.UserRepositoryImpl
import com.isayevapps.cleanarchitectureexample.domain.models.SaveUserNameParam
import com.isayevapps.cleanarchitectureexample.domain.usecases.GetUserNameUseCase
import com.isayevapps.cleanarchitectureexample.domain.usecases.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {

    private val userRepository = UserRepositoryImpl(applicationContext)
    private val saveUserNameUseCase = SaveUserNameUseCase(userRepository)
    private val getUserNameUseCase = GetUserNameUseCase(userRepository)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataTextView = findViewById<TextView>(R.id.dataTextView)
        val dataEditText = findViewById<EditText>(R.id.dataEditText)
        val saveButton = findViewById<Button>(R.id.saveButton)
        val getButton = findViewById<Button>(R.id.getButton)

        saveButton.setOnClickListener {
            val data = dataEditText.text.toString()
            val params = SaveUserNameParam(name = data)
            saveUserNameUseCase.execute(params)
        }

        getButton.setOnClickListener {
            val data = getUserNameUseCase.execute()
            dataTextView.text = "${data.firstName} ${data.lastName}"
        }
    }
}