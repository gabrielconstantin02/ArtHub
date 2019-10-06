package com.android.arthub

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment

class FavoriteCharacterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /*val fragment = getSupportFragmentManager().findFragmentByTag(TAG_FRAGMENT)
        if (fragment != null)
            getSupportFragmentManager().beginTransaction().remove(fragment).commit()*/
        return inflater.inflate(R.layout.fragment_favorite_character, container, false)

    }
}