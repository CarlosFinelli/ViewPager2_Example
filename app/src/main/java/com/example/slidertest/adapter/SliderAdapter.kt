package com.example.slidertest.adapter

import android.content.Context
import android.content.Context.LAYOUT_INFLATER_SERVICE
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.PagerAdapter
import com.example.slidertest.R

class SliderAdapter(private val context: Context) : PagerAdapter() {

    val images = arrayOf(
        R.drawable.elden_ring,
        R.drawable.hollow_knight,
        R.drawable.hollow_knight_splash,
        R.drawable.horizon
    )

    val headings = arrayOf(
        "Heading 1",
        "Heading 2",
        "Heading 3",
        "Heading 4"
    )

    val descs = arrayOf(
        "Desc 1",
        "Desc 2",
        "Desc 3",
        "Desc 4"
    )
    override fun getCount(): Int {
        return headings.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object` as ConstraintLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val layoutInflater = context.getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val convertView = layoutInflater.inflate(R.layout.slider_layout, container, false)

        val slideImage = convertView.findViewById<ImageView>(R.id.slide_image)
        val slideHeading = convertView.findViewById<TextView>(R.id.slide_heading)
        val slideDesc = convertView.findViewById<TextView>(R.id.slide_desc)

        slideImage.setImageResource(images[position])
        slideHeading.setText(headings[position])
        slideDesc.setText(descs[position])

        container.addView(convertView)

        return convertView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as ConstraintLayout)
    }
}