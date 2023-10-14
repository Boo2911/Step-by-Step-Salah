package com.example.projectone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projectone.Adapters.DailyPrayerAdapter
import com.example.projectone.databinding.ActivityDailyPrayerBinding
import com.google.android.material.tabs.TabLayoutMediator

class DailyPrayerActivity : AppCompatActivity() {



    private lateinit var binding: ActivityDailyPrayerBinding
    var tabTitle = arrayOf("FAJAR","DUHR", "ASR",  "MAGHRIB", "ISHA");

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDailyPrayerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewPager3.adapter = DailyPrayerAdapter(supportFragmentManager, lifecycle)

        TabLayoutMediator(binding.tabLayout, binding.viewPager3){
            tab, position-> tab.text = tabTitle[position]
        }.attach()

    }
}