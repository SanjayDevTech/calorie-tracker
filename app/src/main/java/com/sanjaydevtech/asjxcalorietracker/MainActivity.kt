package com.sanjaydevtech.asjxcalorietracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.sanjaydevtech.asjxcalorietracker.adapter.MainViewPagerAdapter
import com.sanjaydevtech.asjxcalorietracker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val tabTitles = listOf("Dairy", "Summary")
    private val repository: Repository by lazy {
        (application as CalorieTracker).repository
    }
    private val tabIcons = listOf(R.drawable.ic_baseline_fastfood_24, R.drawable.ic_baseline_timeline_24)
    private val fragments = listOf(DailyFragment(), WeeklyFragment())
    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelProvider(repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        mainViewModel.dailyDao.getAllDailyData()
        binding.viewPager.adapter = MainViewPagerAdapter(this, fragments)
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab: TabLayout.Tab, i: Int ->
            tab.text = tabTitles[i]
            tab.icon = ContextCompat.getDrawable(this, tabIcons[i])
        }.attach()
    }
}