package com.example.projectone.Adapters

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.projectone.DailyPrayerFragments.AsrFragment
import com.example.projectone.DailyPrayerFragments.DuhrFragment
import com.example.projectone.DailyPrayerFragments.FajarFragment
import com.example.projectone.DailyPrayerFragments.IshaFragment
import com.example.projectone.DailyPrayerFragments.MaghribFragment

class DailyPrayerAdapter(fm: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fm, lifecycle) {
    override fun getItemCount(): Int {
        return 5
    }

    override fun createFragment(position: Int): Fragment {
        when(position){
            0-> return FajarFragment()
            1-> return DuhrFragment()
            2-> return AsrFragment()
            3-> return MaghribFragment()
            4-> return IshaFragment()
            else -> return FajarFragment()
        }
    }


}