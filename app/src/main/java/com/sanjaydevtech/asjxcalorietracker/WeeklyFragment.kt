package com.sanjaydevtech.asjxcalorietracker

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.sanjaydevtech.asjxcalorietracker.databinding.FragmentWeeklyBinding

class WeeklyFragment : Fragment() {

    private val binding: FragmentWeeklyBinding by lazy {
        FragmentWeeklyBinding.inflate(
            layoutInflater
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val barChartEntries: List<BarEntry> = listOf(
            BarEntry(0f, floatArrayOf(2f, 5f, 1f)),
            BarEntry(1f, floatArrayOf(3f, 2f, 4f)),
            BarEntry(2f, floatArrayOf(5f, 1f, 4f)),
            BarEntry(3f, floatArrayOf(2f, 5f, 1f)),
            BarEntry(4f, floatArrayOf(3f, 2f, 1f)),
            BarEntry(5f, floatArrayOf(2f, 5f, 1f)),
            BarEntry(6f, floatArrayOf(2f, 5f, 1f)),
        )
        val colors = listOf(
            ContextCompat.getColor(requireContext(), R.color.primaryLightColor),
            ContextCompat.getColor(requireContext(), R.color.secondaryLightColor),
            ContextCompat.getColor(requireContext(), R.color.teal),
        )
        val barDataSet = BarDataSet(barChartEntries, "Bar set").apply {
            setColors(colors)
        }
        binding.stackedChart.apply {
            description = Description().apply { text = "" }
            setScaleEnabled(false)
            xAxis.isEnabled = false
            axisLeft.isEnabled = false
            axisRight.isEnabled = false
            legend.isEnabled = false
            data = BarData(barDataSet)
        }
    }

}