package com.sanjaydevtech.asjxcalorietracker

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.data.*
import com.sanjaydevtech.asjxcalorietracker.databinding.FragmentWeeklyBinding

class WeeklyFragment : Fragment(), AdapterView.OnItemClickListener {

    private val chartColors by lazy {
        listOf(
            ContextCompat.getColor(requireContext(), R.color.primaryLightColor),
            ContextCompat.getColor(requireContext(), R.color.secondaryLightColor),
            ContextCompat.getColor(requireContext(), R.color.teal),
        )
    }

    private val dayList = listOf("Today", "Yesterday", "This week")

    private val arrayAdapter: ArrayAdapter<CharSequence> by lazy {
        ArrayAdapter(requireContext(), R.layout.simple_textview_layout, dayList)
    }

    private val binding: FragmentWeeklyBinding by lazy {
        FragmentWeeklyBinding.inflate(
            layoutInflater
        )
    }
    private val barChartEntries: List<BarEntry> = listOf(
        BarEntry(0f, floatArrayOf(2f, 5f, 1f)),
        BarEntry(1f, floatArrayOf(3f, 2f, 4f)),
        BarEntry(2f, floatArrayOf(5f, 1f, 4f)),
        BarEntry(3f, floatArrayOf(2f, 5f, 1f)),
        BarEntry(4f, floatArrayOf(3f, 2f, 1f)),
        BarEntry(5f, floatArrayOf(2f, 5f, 1f)),
        BarEntry(6f, floatArrayOf(2f, 5f, 1f)),
    )

    private val pieChartEntries: List<PieEntry> = listOf(
        PieEntry(4f),
        PieEntry(5f),
        PieEntry(6f),
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val barDataSet = BarDataSet(barChartEntries, "Bar set").apply {
            colors = chartColors
        }

        val pieDataSet = PieDataSet(pieChartEntries, "Pie set").apply {
            colors = chartColors
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
        binding.pieChart.apply {
            description = Description().apply { text = "" }
            legend.isEnabled = false
            data = PieData(pieDataSet)
        }
        binding.outlinedText.setAdapter(arrayAdapter)
        binding.outlinedText.onItemClickListener = this
        binding.outlinedText.setText("Today", false)
        binding.stackedChart.visibility = View.GONE
        binding.pieChart.visibility = View.VISIBLE
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        when (position) {
            2 -> {
                binding.stackedChart.visibility = View.VISIBLE
                binding.pieChart.visibility = View.GONE
            }
            else -> {
                binding.stackedChart.visibility = View.GONE
                binding.pieChart.visibility = View.VISIBLE
            }
        }
    }


}