package com.sanjaydevtech.asjxcalorietracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.sanjaydevtech.asjxcalorietracker.adapter.MainViewPagerAdapter
import com.sanjaydevtech.asjxcalorietracker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val tabTitles = listOf("Daily", "Weekly")
    private val tabIcons = listOf(R.drawable.ic_baseline_fastfood_24, R.drawable.ic_baseline_timeline_24)
    private val fragments = listOf(DailyFragment(), WeeklyFragment())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        binding.viewPager.adapter = MainViewPagerAdapter(this, fragments)
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab: TabLayout.Tab, i: Int ->
            tab.text = tabTitles[i]
            tab.icon = ContextCompat.getDrawable(this, tabIcons[i])
        }.attach()
    }
}