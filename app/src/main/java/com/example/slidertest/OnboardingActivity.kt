package com.example.slidertest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.TextView
import androidx.viewpager2.widget.ViewPager2
import com.example.slidertest.adapter.OnboardingAdapter
import com.example.slidertest.classes.OnboardingItems
import com.example.slidertest.databinding.ActivityOnboardingBinding

class OnboardingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOnboardingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "OnboardingActivity"

        setOnboardingItems()
        binding.slider.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                addDots(position)
            }
        })
        addDots(0)
    }

    fun setOnboardingItems() {
        val arrayList: ArrayList<OnboardingItems> = ArrayList()
        val onboardingItem1 = OnboardingItems()
        onboardingItem1.desc = "Desc 1"
        onboardingItem1.heading = "Heading 1"
        onboardingItem1.image = R.drawable.elden_ring

        val onboardingItem2 = OnboardingItems()
        onboardingItem2.desc = "Desc 2"
        onboardingItem2.heading = "Heading 2"
        onboardingItem2.image = R.drawable.hollow_knight

        val onboardingItem3 = OnboardingItems()
        onboardingItem3.desc = "Desc 3"
        onboardingItem3.heading = "Heading 3"
        onboardingItem3.image = R.drawable.hollow_knight_splash

        val onboardingItem4 = OnboardingItems()
        onboardingItem4.desc = "Desc 4"
        onboardingItem4.heading = "Heading 4"
        onboardingItem4.image = R.drawable.horizon

        arrayList.add(onboardingItem1)
        arrayList.add(onboardingItem2)
        arrayList.add(onboardingItem3)
        arrayList.add(onboardingItem4)

        binding.slider.adapter = OnboardingAdapter(baseContext, arrayList)
        addDots(0)
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
}