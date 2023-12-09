package com.infinite.tugaskotlinadvance.pages.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.infinite.tugaskotlinadvance.R
import com.infinite.tugaskotlinadvance.databinding.ActivityFragmentBinding
import com.infinite.tugaskotlinadvance.pages.fragment.fragments.FragmentOne
import com.infinite.tugaskotlinadvance.pages.fragment.fragments.FragmentTwo

class FragmentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
    }

    private fun init() {
        binding.btnFragmentOne.setOnClickListener {
            replaceFragment(FragmentOne())
        }
        binding.btnFragmentTwo.setOnClickListener {
            replaceFragment(FragmentTwo())
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            addToBackStack(null)
            commit()
        }
    }
}