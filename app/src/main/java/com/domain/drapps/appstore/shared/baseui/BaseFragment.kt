package com.domain.drapps.appstore.shared.baseui

import android.os.Bundle
import androidx.fragment.app.Fragment



open class BaseFragment : Fragment() {

    lateinit var parentActivity: BaseActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        parentActivity = requireActivity() as BaseActivity
    }

    fun startLoading() {
        parentActivity.runOnUiThread {
            parentActivity.startLoading()
        }
    }

    fun stopLoading() {
        parentActivity.runOnUiThread {
            parentActivity.stopLoading()
        }
    }
}
