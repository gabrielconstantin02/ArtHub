package com.android.arthub.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.android.arthub.OnSwipeTouchListener
import com.android.arthub.R
import com.squareup.picasso.Picasso

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(this, Observer {
            textView.text = it
        })
        val imageView: ImageView = root.findViewById(R.id.imageView)
        root.setOnTouchListener(object : OnSwipeTouchListener() {
            override fun onSwipeLeft() {
                Log.e("ViewSwipe", "Left")
            }

            override fun onSwipeRight() {
                Log.e("ViewSwipe", "Right")
            }
        })
        Picasso.get()
            .load("https://imgur.com/Kmm6TIk.jpg")
//            .resize(50,50)
            .placeholder(R.drawable.ic_star)
            .error(R.drawable.ic_tv)
            .into(imageView, object: com.squareup.picasso.Callback {
                override fun onSuccess() {
                    //set animations here

                }

                override fun onError(ex:Exception) {
                    ex.printStackTrace()
                    //do smth when there is picture loading error
                }
            })
        return root
    }
}