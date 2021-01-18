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
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.data.*
import com.sanjaydevtech.asjxcalorietracker.databinding.FragmentWeeklyBinding
import kotlinx.coroutines.launch
import java.util.*

class WeeklyFragment : Fragment(), AdapterView.OnItemClickListener {

    private val chartColors by lazy {
        listOf(
            ContextCompat.getColor(requireContext(), R.color.primaryLightColor),
            ContextCompat.getColor(requireContext(), R.color.secondaryLightColor),
            ContextCompat.getColor(requireContext(), R.color.teal),
        )
    }

    private val mainViewModel: MainViewModel by activityViewModels()

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

    private val pieDemoData by lazy {
        PieData(
            PieDataSet(
                listOf(
                    PieEntry(5f),
                    PieEntry(8f),
                    PieEntry(10f),
                ), "pie demo"
            ).apply {
                colors = chartColors
            }
        )
    }

    private var pieChartTodayEntries: List<PieEntry> = listOf()
    private var pieTodayData: PieData? = null
    private var pieChartYesterdayEntries: List<PieEntry> = listOf()
    private var pieYesterdayData: PieData? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        viewLifecycleOwner.lifecycleScope.launch {
//            val calendar = Calendar.getInstance()
//            val date = calendar[Calendar.DAY_OF_MONTH]
//            val month = calendar[Calendar.MONTH] + 1
//            val year = calendar[Calendar.YEAR]
//            val todayDailyData = mainViewModel.dailyDao.getDailyData(date, month, year)
//            calendar.add(Calendar.DAY_OF_MONTH, -1)
//            val yesterdayDate = calendar[Calendar.DAY_OF_MONTH]
//            val yesterdayMonth = calendar[Calendar.MONTH] + 1
//            val yesterdayYear = calendar[Calendar.YEAR]
//            val yesterdayDailyData =
//                mainViewModel.dailyDao.getDailyData(yesterdayDate, yesterdayMonth, yesterdayYear)
//            todayDailyData?.let {
//                pieChartTodayEntries = listOf(
//                    PieEntry(it.breakFast.calorie.toFloat(), "Breakfast"),
//                    PieEntry(it.lunch.calorie.toFloat(), "Lunch"),
//                    PieEntry(it.dinner.calorie.toFloat(), "Dinner"),
//                )
//            }
//
//            yesterdayDailyData?.let {
//                pieChartYesterdayEntries = listOf(
//                    PieEntry(it.breakFast.calorie.toFloat(), "Breakfast"),
//                    PieEntry(it.lunch.calorie.toFloat(), "Lunch"),
//                    PieEntry(it.dinner.calorie.toFloat(), "Dinner"),
//                )
//            }
//
//            pieTodayData = PieData(PieDataSet(pieChartTodayEntries, "Today summary").apply {
//                colors = chartColors
//            })
//            pieYesterdayData =
//                PieData(PieDataSet(pieChartYesterdayEntries, "Yesterday summary").apply {
//                    colors = chartColors
//                })
//        }
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val barDataSet = BarDataSet(barChartEntries, "Bar set").apply {
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
        }
        binding.outlinedText.setAdapter(arrayAdapter)
        binding.outlinedText.onItemClickListener = this
        binding.outlinedText.setText("Today", false)
        binding.stackedChart.visibility = View.GONE
        binding.pieChart.visibility = View.VISIBLE
        binding.pieChart.data = pieDemoData
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        when (position) {
            0 -> {
                binding.stackedChart.visibility = View.GONE
                binding.pieChart.visibility = View.VISIBLE
            }
            1 -> {
                binding.stackedChart.visibility = View.GONE
                binding.pieChart.visibility = View.VISIBLE
            }
            2 -> {
                binding.stackedChart.visibility = View.VISIBLE
                binding.pieChart.visibility = View.GONE
            }
        }
    }


}