package com.example.slidertest

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.example.slidertest.adapter.SliderAdapter
import com.example.slidertest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "MainActivity"

        val viewPager = binding.slider

        val adapter = SliderAdapter(baseContext)
        viewPager.adapter = adapter
        addDots(0)
        viewPager.addOnPageChangeListener(viewListener)
    }

    fun addDots(position: Int) {
        val mDots = ArrayList<TextView>()
        binding.dots.removeAllViews()
        for (i in 0 until 4) {
            val textView = TextView(this)
            textView.setText(Html.fromHtml("&#8226"))
            textView.setTextSize(35f)
            textView.setTextColor(resources.getColor(R.color.colorTransparentWhite))
            mDots.add(textView)
            binding.dots.addView(mDots[i])
        }

        if (mDots.size > 0) {
            mDots[position].setTextColor(resources.getColor(R.color.white))
        }
    }

    val viewListener = object: ViewPager.OnPageChangeListener {
        override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int
        ) {

        }

        override fun onPageSelected(position: Int) {
            addDots(position)
        }

        override fun onPageScrollStateChanged(state: Int) {

        }

    }
}