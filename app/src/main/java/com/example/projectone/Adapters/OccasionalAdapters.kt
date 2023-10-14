package com.example.projectone.Adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.projectone.OccasionalFragments.EidFragment
import com.example.projectone.OccasionalFragments.FuneralFragment
import com.example.projectone.OccasionalFragments.IstikharaFragment
import com.example.projectone.OccasionalFragments.JummaFragment
import com.example.projectone.OccasionalFragments.TasbeehFragment

class OccasionalAdapters (fm: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fm, lifecycle) {
    override fun getItemCount(): Int {
        return 5
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return JummaFragment()
            1 -> return FuneralFragment()
            2 -> return TasbeehFragment()
            3 -> return IstikharaFragment()
            4 -> return EidFragment()
            else -> return JummaFragment()
        }
    }
}