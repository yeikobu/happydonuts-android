package com.example.happydonuts

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    private lateinit var topView: View
    private lateinit var loginAndRegisterTabLayout: TabLayout
    private lateinit var loginAndRegisterViewPager2: ViewPager2
    private lateinit var loginFragmentAdapter: LoginFragmentAdapter
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        topView = findViewById(R.id.topView)
        loginAndRegisterTabLayout = findViewById(R.id.tabLayout)
        loginAndRegisterViewPager2 = findViewById(R.id.viewPager2)
        loginFragmentAdapter = LoginFragmentAdapter(supportFragmentManager, lifecycle)

//        loginAndRegisterTabLayout.addTab(loginAndRegisterTabLayout.newTab().setText("Login"))
//        loginAndRegisterTabLayout.addTab(loginAndRegisterTabLayout.newTab().setText("Registro"))
        loginAndRegisterTabLayout

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
                if (position == 0) {
                    loginAndRegisterTabLayout.setSelectedTabIndicator(R.drawable.login_tab_indicator)
                    topView.setBackgroundColor(getColor(R.color.pink))
                } else {
                    loginAndRegisterTabLayout.setSelectedTabIndicator(R.drawable.register_tab_indicator)
                    topView.setBackgroundColor(getColor(R.color.green))
                }
            }
        })
    }
}