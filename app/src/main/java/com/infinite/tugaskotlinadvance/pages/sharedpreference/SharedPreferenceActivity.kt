package com.infinite.tugaskotlinadvance.pages.sharedpreference

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.infinite.tugaskotlinadvance.databinding.ActivitySharedPreferenceBinding
import com.infinite.tugaskotlinadvance.utils.Constants.EMAIL
import com.infinite.tugaskotlinadvance.utils.Constants.MY_SESSION
import com.infinite.tugaskotlinadvance.utils.Constants.USERNAME

class SharedPreferenceActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySharedPreferenceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySharedPreferenceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initButtonSubmit()
        initButtonResult()
    }

    private fun initButtonSubmit() {
        binding.btnSubmit.setOnClickListener {
            val username = binding.etUsername.text.toString()
            val email = binding.etEmail.text.toString()

            val sharedPreferences = getSharedPreferences(MY_SESSION, Context.MODE_PRIVATE)
            val edit = sharedPreferences.edit()

            edit.apply {
                putString(USERNAME, username)
                putString(EMAIL, email)
                apply()
            }

            Toast.makeText(this, "Berhasil menyimpan data", Toast.LENGTH_SHORT).show()
        }
    }

    private fun initButtonResult() {
        binding.btnSeeResult.setOnClickListener {
            val sharedPreferences = getSharedPreferences(MY_SESSION, Context.MODE_PRIVATE)
            val username = sharedPreferences.getString(USERNAME, "-")
            val email = sharedPreferences.getString(EMAIL, "-")

            binding.resultContainer.visibility = View.VISIBLE
            binding.tvUsernameResult.text = username
            binding.tvEmailResult.text = email
        }
    }
}