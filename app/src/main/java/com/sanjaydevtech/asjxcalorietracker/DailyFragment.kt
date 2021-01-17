package com.sanjaydevtech.asjxcalorietracker

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.sanjaydevtech.asjxcalorietracker.databinding.FragmentDailyBinding
import com.sanjaydevtech.asjxcalorietracker.databinding.LayoutTimeFoodBinding

class DailyFragment : Fragment() {

    private val binding: FragmentDailyBinding by lazy { FragmentDailyBinding.inflate(layoutInflater) }

    private val adapter = object : BaseAdapter() {

        private val foodList = listOf("Breakfast", "Lunch", "Dinner")

        override fun getCount() = foodList.size

        override fun getItem(position: Int) = foodList[position]

        override fun getItemId(position: Int) = position.toLong()

        @SuppressLint("ViewHolder")
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?) =
            convertView ?: LayoutTimeFoodBinding.inflate(layoutInflater).apply {
                title.text = foodList[position]
                cardView.setOnClickListener { dropdown.expandListeners(foodListView, addBtn) }
                dropdown.setOnClickListener { dropdown.expandListeners(foodListView, addBtn) }
                addBtn.setOnClickListener {  }
            }.root
    }

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

    private fun ImageView.expandListeners(listView: ListView, addBtn: View) {

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
}