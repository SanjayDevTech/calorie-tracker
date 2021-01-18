package com.sanjaydevtech.asjxcalorietracker.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sanjaydevtech.asjxcalorietracker.databinding.LayoutFoodViewBinding
import com.sanjaydevtech.asjxcalorietracker.model.Food

class FoodListAdapter(foods: List<Food>) : RecyclerView.Adapter<FoodListAdapter.FoodViewHolder>() {

    var foodList = foods
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = FoodViewHolder(
        LayoutFoodViewBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val food = foodList[position]
        holder.binding.apply {
            foodName.text = food.name
            foodCal.text = "/ ${food.calorie} kCal"
            foodRemoveBtn.setOnClickListener {  }
        }
    }

    override fun getItemCount() = foodList.size

    inner class FoodViewHolder(val binding: LayoutFoodViewBinding) : RecyclerView.ViewHolder(binding.root)
}