package com.example.slidertest.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.slidertest.R
import com.example.slidertest.classes.OnboardingItems

class OnboardingAdapter(private val context: Context, private val arrayList: ArrayList<OnboardingItems>) : RecyclerView.Adapter<OnboardingAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image = itemView.findViewById<ImageView>(R.id.slide_image)
        var heading = itemView.findViewById<TextView>(R.id.slide_heading)
        var desc = itemView.findViewById<TextView>(R.id.slide_desc)

        fun setOnboardingData(onboardingItems: OnboardingItems) {
            desc.setText(onboardingItems.desc)
            heading.setText(onboardingItems.heading)
            image.setImageResource(onboardingItems.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.slider_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setOnboardingData(arrayList.get(position))
    }
}