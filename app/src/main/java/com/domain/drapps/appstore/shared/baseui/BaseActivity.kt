package com.domain.drapps.appstore.shared.baseui

import android.view.View
import android.widget.ProgressBar
import androidx.fragment.app.FragmentActivity
import com.domain.drapps.appstore.R
import kotlinx.android.synthetic.main.rootlayout.*

abstract class BaseActivity : FragmentActivity() {

    lateinit var loadingView: ProgressBar
    override fun setContentView(layoutResID: Int) {
        super.setContentView(R.layout.rootlayout)

        loadingView = findViewById(R.id.loadingView)
        framelayout.addView(layoutInflater.inflate(layoutResID, null))
    }

    fun startLoading() {
        loadingView.visibility = View.VISIBLE
    }

    fun stopLoading() {
        loadingView.visibility = View.GONE
    }
}
