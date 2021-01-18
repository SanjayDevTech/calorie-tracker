package com.sanjaydevtech.asjxcalorietracker.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.sanjaydevtech.asjxcalorietracker.databinding.LayoutTimeFoodBinding
import com.sanjaydevtech.asjxcalorietracker.model.TimeData

class TimeListAdapter(private val timeList: List<TimeData>) : RecyclerView.Adapter<TimeListAdapter.TimeViewHolder>() {
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
            addBtn.setOnClickListener {  }
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