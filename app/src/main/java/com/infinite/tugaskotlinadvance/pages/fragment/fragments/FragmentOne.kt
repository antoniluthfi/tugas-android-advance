package com.infinite.tugaskotlinadvance.pages.fragment.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.infinite.tugaskotlinadvance.R
import com.infinite.tugaskotlinadvance.databinding.FragmentOneBinding

class FragmentOne : Fragment() {
    private var binding: FragmentOneBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOneBinding.inflate(layoutInflater)
        return binding!!.root
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}