package com.isayevapps.cleanarchitectureexample.presentation

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.isayevapps.cleanarchitectureexample.R
import com.isayevapps.cleanarchitectureexample.data.repository.UserRepositoryImpl
import com.isayevapps.cleanarchitectureexample.data.storage.SharedPrefUserStorage
import com.isayevapps.cleanarchitectureexample.domain.usecases.GetUserNameUseCase
import com.isayevapps.cleanarchitectureexample.domain.usecases.SaveUserNameUseCase
import com.isayevapps.cleanarchitectureexample.domain.models.SaveUserNameParam

class MainActivity : AppCompatActivity() {

    private val userRepository by lazy { UserRepositoryImpl(SharedPrefUserStorage(applicationContext)) }
    private val saveUserNameUseCase by lazy {
        SaveUserNameUseCase(
            userRepository
        )
    }
    private val getUserNameUseCase by lazy {
        GetUserNameUseCase(
            userRepository
        )
    }

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