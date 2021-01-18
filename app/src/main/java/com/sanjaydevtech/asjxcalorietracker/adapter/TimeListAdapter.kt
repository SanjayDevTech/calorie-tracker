package com.sanjaydevtech.asjxcalorietracker.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ListView
import androidx.recyclerview.widget.RecyclerView
import com.sanjaydevtech.asjxcalorietracker.databinding.LayoutTimeFoodBinding
import com.sanjaydevtech.asjxcalorietracker.model.TimeData

class TimeListAdapter(private val timeList: List<TimeData>) : RecyclerView.Adapter<TimeListAdapter.FoodViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = FoodViewHolder(LayoutTimeFoodBinding.inflate(
        LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
       val time = timeList[position]
        holder.binding.apply {
            title.text = time.title
            cardView.setOnClickListener { dropdown.expandListeners(foodListView, addBtn) }
            dropdown.setOnClickListener { dropdown.expandListeners(foodListView, addBtn) }
            addBtn.setOnClickListener {  }
        }
    }

    override fun getItemCount() = timeList.size

    inner class FoodViewHolder(val binding: LayoutTimeFoodBinding) : RecyclerView.ViewHolder(binding.root)
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