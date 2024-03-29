package com.sanjaydevtech.asjxcalorietracker.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.sanjaydevtech.asjxcalorietracker.CalorieTracker
import com.sanjaydevtech.asjxcalorietracker.databinding.LayoutTimeFoodBinding
import com.sanjaydevtech.asjxcalorietracker.model.Food
import com.sanjaydevtech.asjxcalorietracker.model.TimeData
import kotlinx.coroutines.launch

class TimeListAdapter(private val activity: FragmentActivity, private val timeList: List<TimeData>) : RecyclerView.Adapter<TimeListAdapter.TimeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = TimeViewHolder(LayoutTimeFoodBinding.inflate(
        LayoutInflater.from(parent.context), parent, false))

    private val foodAdapters by lazy {
        timeList.map { time ->
            FoodListAdapter(time.foodList)
        }
    }

    override fun onBindViewHolder(holder: TimeViewHolder, position: Int) {
       val time = timeList[position]
        holder.binding.apply {
            title.text = time.title
            cardView.setOnClickListener { dropdown.expandListeners(foodListView, addBtn) }
            dropdown.setOnClickListener { dropdown.expandListeners(foodListView, addBtn) }
            addBtn.setOnClickListener {
                val foodList = foodAdapters[position].foodList.toMutableList()
                foodList.add(Food("1", "Dosai", 133))
                foodAdapters[position].foodList = foodList
                val calories = foodList.reduce { acc, food ->
                    Food("", "", acc.calorie+food.calorie)
                }.calorie
            }
            foodListView.adapter = foodAdapters[position]
        }
    }

    override fun getItemCount() = timeList.size

    inner class TimeViewHolder(val binding: LayoutTimeFoodBinding) : RecyclerView.ViewHolder(binding.root)
}

 fun ImageView.expandListeners(listView: RecyclerView, addBtn: View) {

    animate().apply {
        duration = 300L
        rotationBy(180f)
    }
    listView.visibility = if (listView.visibility == View.GONE) {
        View.VISIBLE
    } else {
        View.GONE
    }
    addBtn.visibility = listView.visibility

}