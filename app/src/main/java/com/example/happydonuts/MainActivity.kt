package com.example.happydonuts

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener

class MainActivity : AppCompatActivity() {
    private lateinit var loginAndRegisterTabLayout: TabLayout
    private lateinit var loginAndRegisterViewPager2: ViewPager2
    private lateinit var loginFragmentAdapter: LoginFragmentAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        loginAndRegisterTabLayout = findViewById(R.id.tabLayout)
        loginAndRegisterViewPager2 = findViewById(R.id.viewPager2)
        loginFragmentAdapter = LoginFragmentAdapter(supportFragmentManager, lifecycle)

//        loginAndRegisterTabLayout.addTab(loginAndRegisterTabLayout.newTab().setText("Login"))
//        loginAndRegisterTabLayout.addTab(loginAndRegisterTabLayout.newTab().setText("Registro"))

        loginAndRegisterViewPager2.adapter = loginFragmentAdapter

        loginAndRegisterTabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    loginAndRegisterViewPager2.currentItem = tab.position
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })

        loginAndRegisterViewPager2.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                loginAndRegisterTabLayout.selectTab(loginAndRegisterTabLayout.getTabAt(position))
            }
        })
    }
}