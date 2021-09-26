package com.ramiguev.arhepp.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.viewpager.widget.ViewPager
import com.google.firebase.auth.FirebaseAuth
import com.ramiguev.arhepp.R
import com.ramiguev.arhepp.adapters.PagerAdapter
import com.ramiguev.arhepp.databinding.ActivityHomeBinding
import com.ramiguev.arhepp.view.fragments.ExplorerFragment
import com.ramiguev.arhepp.view.fragments.FavoritesFragment
import com.ramiguev.arhepp.view.fragments.ProfileFragment
import com.ramiguev.arhepp.view.fragments.RecFragment

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    private var previewBottomSelected : MenuItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun getPagerAdapter() : PagerAdapter {
        val pagerAdapter = PagerAdapter(supportFragmentManager)
        pagerAdapter.addFragment(ExplorerFragment())
        pagerAdapter.addFragment(RecFragment())
        pagerAdapter.addFragment(FavoritesFragment())
        pagerAdapter.addFragment(ProfileFragment())
        return pagerAdapter
    }

    private fun setUpViewPager(pagerAdapter: PagerAdapter) {
        binding.viewPager.adapter = pagerAdapter
        binding.viewPager.offscreenPageLimit = pagerAdapter.count
        binding.viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {}
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
            override fun onPageSelected(position: Int) {

                if (previewBottomSelected == null) {
                    binding.bottomNavigation.menu.getItem(0).isChecked = false
                } else {
                    previewBottomSelected!!.isChecked = false
                }
                binding.bottomNavigation.menu.getItem(position).isChecked = true
                previewBottomSelected = binding.bottomNavigation.menu.getItem(position)
            }
        })
    }

    private fun setUpBottomNavigationBar() {

        binding.bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.bottom_nav_home -> {
                    binding.viewPager.currentItem = 0
                    true
                }
                R.id.bottom_nav_explorer -> {
                    binding.viewPager.currentItem = 1
                    true
                }
                R.id.bottom_nav_recording -> {
                    binding.viewPager.currentItem = 2
                    true
                }
                R.id.bottom_nav_favorites -> {
                    binding.viewPager.currentItem = 3
                    true
                }
                R.id.bottom_nav_profile -> {
                    binding.viewPager.currentItem = 4
                    true
                }
                else ->
                    false
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.general_options_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.menuLogOut -> {
                FirebaseAuth.getInstance().signOut()
                val intent = Intent(this, LoginActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}