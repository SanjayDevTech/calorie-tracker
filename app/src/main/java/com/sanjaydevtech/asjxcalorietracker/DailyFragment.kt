package com.sanjaydevtech.asjxcalorietracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sanjaydevtech.asjxcalorietracker.databinding.FragmentDailyBinding

class DailyFragment : Fragment() {

    private val binding: FragmentDailyBinding by lazy { FragmentDailyBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return binding.root
    }
}