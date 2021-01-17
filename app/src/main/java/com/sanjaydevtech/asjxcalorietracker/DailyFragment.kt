package com.sanjaydevtech.asjxcalorietracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.view.animation.LinearInterpolator
import androidx.vectordrawable.graphics.drawable.AnimationUtilsCompat
import com.sanjaydevtech.asjxcalorietracker.databinding.FragmentDailyBinding

class DailyFragment : Fragment() {

    private val binding: FragmentDailyBinding by lazy { FragmentDailyBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.button.setOnClickListener {
            it.animate().apply {
                duration = 300L
                rotationBy(180f)
            }
            binding.imageView.visibility = if (binding.imageView.visibility == View.GONE) {
                View.VISIBLE
            } else {
                View.GONE
            }
        }
    }
}