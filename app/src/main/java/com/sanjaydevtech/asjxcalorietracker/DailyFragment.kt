package com.sanjaydevtech.asjxcalorietracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.sanjaydevtech.asjxcalorietracker.adapter.TimeListAdapter
import com.sanjaydevtech.asjxcalorietracker.databinding.FragmentDailyBinding
import com.sanjaydevtech.asjxcalorietracker.model.TimeData

class DailyFragment : Fragment() {

    private val binding: FragmentDailyBinding by lazy { FragmentDailyBinding.inflate(layoutInflater) }

    private val timeList = listOf(TimeData("Breakfast"), TimeData("Lunch"), TimeData("Dinner"))

    private val adapter by lazy { TimeListAdapter(requireActivity(), timeList) }

    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.mainListView.adapter = adapter
    }
}