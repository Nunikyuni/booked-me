package com.example.booked_me.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.booked_me.R
import com.example.booked_me.presentation.nav_fragments.BookmarkFragment
import com.example.booked_me.presentation.nav_fragments.CartFragment
import com.example.booked_me.presentation.nav_fragments.HomeFragment
import com.example.booked_me.presentation.nav_fragments.ProfileFragment

class MainActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val homeFragment = HomeFragment()
        val bookmarkFragment = BookmarkFragment()
        val cartFragment = CartFragment()
        val profileFragment = ProfileFragment()


        makeCurrentFragment(homeFragment)

        val bottomNavigation : com.google.android.material.bottomnavigation.BottomNavigationView = findViewById(
            R.id.bottom_navigation
        )

        bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.ic_home -> makeCurrentFragment(homeFragment)
                R.id.ic_bookmark -> makeCurrentFragment(bookmarkFragment)
                R.id.ic_cart -> makeCurrentFragment(cartFragment)
                R.id.ic_profile -> makeCurrentFragment(profileFragment)
            }
            true
        }
    }

    private fun makeCurrentFragment(fragment : Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }

    override fun onClick(v: View?) {
        when (v?.id) {

        }
    }
}