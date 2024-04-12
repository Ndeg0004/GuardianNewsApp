package com.example.cst2335finalproject

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.cst2335finalproject.UI.Favorites.FavoritesFragments
import com.example.cst2335finalproject.UI.Home.HomeFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        //  switch for dark mode
        val switchDarkMode: Switch = findViewById(R.id.switchDarkMode)
        switchDarkMode.setOnCheckedChangeListener { _, isChecked ->
            // Handle dark mode setting change
            if (isChecked) {
                //  dark mode
                enableDarkMode()
            } else {
                //  dark mode
                disableDarkMode()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_home -> {
                // Load Home Fragment
                loadHomeFragment()
                true
            }
            R.id.menu_favorites -> {
                // Favorites Fragment
                loadFavoritesFragment()
                true
            }
            R.id.menu_settings -> {
                // settings UI
                // load a separate fragment
                true
            }
            R.id.menu_logout -> {
                // Logout
                logout()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    // Load Home Fragment initially
    private fun loadHomeFragment() {
        val fragmentManager = supportFragmentManager
        val homeFragment: Fragment = HomeFragment()
        fragmentManager.beginTransaction()
            .replace(R.id.fragment_container, homeFragment)
            .commit()
    }

    //  Favorites Fragment
    private fun loadFavoritesFragment() {
        val fragmentManager = supportFragmentManager
        val favoritesFragment: Fragment = FavoritesFragments()
        fragmentManager.beginTransaction()
            .replace(R.id.fragment_container, favoritesFragment)
            .commit()
    }

    private fun enableDarkMode() {
        // Implement dark mode logic here
    }

    private fun disableDarkMode() {
        //  disable dark mode here
    }

    // Logout function
    private fun logout() {
        // Close the app
        finish()
    }
}

