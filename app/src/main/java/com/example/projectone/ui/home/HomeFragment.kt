package com.example.projectone.ui.home

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.projectone.Adapters.ImageAdapter
import com.example.projectone.DailyPrayerActivity
import com.example.projectone.OccasionalActivity
import com.example.projectone.R
import com.example.projectone.databinding.FragmentHomeBinding
import java.lang.Math.abs

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var adapter: ImageAdapter
    private lateinit var imageList: ArrayList<Int>
    private lateinit var handler: Handler


    //for all activities on this page


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        handler = Handler(Looper.myLooper()!!)

        imageList = ArrayList()

        imageList.add(R.drawable.imgone)
        imageList.add(R.drawable.imgtwo)
        imageList.add(R.drawable.imgthree)
        imageList.add(R.drawable.imgfour)
        imageList.add(R.drawable.imgfive)

        adapter = ImageAdapter(imageList, binding.viewPager)

        binding.viewPager.adapter = adapter
        binding.viewPager.offscreenPageLimit = 3
        binding.viewPager.clipToPadding = false
        binding.viewPager.clipChildren = false
        binding.viewPager.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

        setUpTransformer()

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                handler.removeCallbacks(runnable)
                handler.postDelayed(runnable, 2000)

            }
        })


        //for all activities the list of activities and their name

        binding.a1.setOnClickListener{

            var intent = Intent(context, DailyPrayerActivity::class.java)
            startActivity(intent);
        }

        binding.a2.setOnClickListener{

            var intent = Intent(context, OccasionalActivity::class.java)
            startActivity(intent);
        }



        return root
    }







    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(runnable)
    }

    override fun onResume() {
        super.onResume()
        handler.postDelayed(runnable, 2000)
    }

    private val runnable = Runnable {
        binding.viewPager.currentItem = binding.viewPager.currentItem+1;

    }

    private fun setUpTransformer(){
        val transformer = CompositePageTransformer()
        transformer.addTransformer(MarginPageTransformer(40))
        transformer.addTransformer { page, position -> val r = 1-abs(position)
        page.scaleY=0.85f+r+0.14f}

        binding.viewPager.setPageTransformer(transformer)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}