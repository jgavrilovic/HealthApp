package rs.raf.projekat1.view.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import rs.raf.projekat1.R
import rs.raf.projekat1.view.viewPager.PagerAdapter


class BottomNavigationActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        initViewPager()
        initNavigation()
    }
    private fun initViewPager() {
        viewPager.adapter =
            PagerAdapter(supportFragmentManager)
    }
    private fun initNavigation() {
        bottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.navigation_1 -> {viewPager.setCurrentItem(PagerAdapter.FRAGMENT_1, false)}
                R.id.navigation_2-> {viewPager.setCurrentItem(PagerAdapter.FRAGMENT_2, false)}
                R.id.navigation_3-> {viewPager.setCurrentItem(PagerAdapter.FRAGMENT_3, false)}
                R.id.navigation_4 -> {viewPager.setCurrentItem(PagerAdapter.FRAGMENT_4, false)}
            }
            return@setOnNavigationItemSelectedListener true
        }
    }
}

