package com.infinite.tugaskotlinadvance

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.infinite.tugaskotlinadvance.databinding.ActivityMainBinding
import com.infinite.tugaskotlinadvance.pages.fetchapi.FetchApiActivity
import com.infinite.tugaskotlinadvance.pages.fragment.FragmentActivity
import com.infinite.tugaskotlinadvance.pages.sharedpreference.SharedPreferenceActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initButtonFragment()
        initButtonSharedPreference()
        initButtonFetchApi()
    }

    private fun initButtonFragment() {
        binding.btnFragment.setOnClickListener {
            val intent = Intent(this, FragmentActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initButtonSharedPreference() {
        binding.btnSharedPreference.setOnClickListener {
            val intent = Intent(this, SharedPreferenceActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initButtonFetchApi() {
        binding.btnFetchApi.setOnClickListener {
            val intent = Intent(this, FetchApiActivity::class.java)
            startActivity(intent)
        }
    }
}