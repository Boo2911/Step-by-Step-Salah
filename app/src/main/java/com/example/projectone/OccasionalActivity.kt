package com.example.projectone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projectone.Adapters.DailyPrayerAdapter
import com.example.projectone.databinding.ActivityDailyPrayerBinding
import com.example.projectone.databinding.ActivityOccasionalBinding
import com.google.android.material.tabs.TabLayoutMediator

class OccasionalActivity : AppCompatActivity() {


    private lateinit var binding: ActivityOccasionalBinding
    var tabTitle = arrayOf("JUMMA","FUNERAL", "TASBEEH",  "ISTIKHARA", "EID");

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOccasionalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewPager.adapter = DailyPrayerAdapter(supportFragmentManager, lifecycle)

        TabLayoutMediator(binding.tabLayout, binding.viewPager){
                tab, position-> tab.text = tabTitle[position]
        }.attach()

    }
}