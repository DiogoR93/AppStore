package com.domain.drapps.appstore

import android.os.Bundle
import com.domain.drapps.appstore.features.applist.ui.HomeStoreFragment
import com.domain.drapps.appstore.features.appsearch.ui.AppSearchFragment
import com.domain.drapps.appstore.shared.baseui.BaseActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    var currentBottomItem: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        supportFragmentManager.beginTransaction().replace(fl_content.id,
            HomeStoreFragment()
        ).commit()
        currentBottomItem = R.id.navigation_home
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        if (currentBottomItem != item.itemId) {
            currentBottomItem = item.itemId
            when (item.itemId) {
                R.id.navigation_home -> {
                    supportFragmentManager.beginTransaction().replace(fl_content.id,
                        HomeStoreFragment()
                    ).commit()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_dashboard -> {
                    supportFragmentManager.beginTransaction().replace(fl_content.id,
                        AppSearchFragment()
                    ).commit()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_notifications -> {
                    return@OnNavigationItemSelectedListener true
                }
            }
        }
        false
    }
}
