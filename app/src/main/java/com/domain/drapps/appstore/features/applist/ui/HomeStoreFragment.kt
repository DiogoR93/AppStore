package com.domain.drapps.appstore.features.applist.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.domain.drapps.appstore.*
import com.domain.drapps.appstore.features.applist.presentation.HomeStoreContract
import com.domain.drapps.appstore.features.applist.presentation.HomeStoreScene
import com.domain.drapps.appstore.shared.baseui.BaseFragment
import com.domain.drapps.appstore.shared.entities.AppObject
import com.domain.drapps.appstore.shared.entities.AppObjectAdapter
import com.domain.drapps.appstore.shared.enums.EnumAppLayoutType
import kotlinx.android.synthetic.main.fragment_home_store.*
import kotlinx.android.synthetic.main.fragment_home_store.view.*

class HomeStoreFragment : BaseFragment(), HomeStoreContract.View {

    override lateinit var presenter: HomeStoreContract.Presenter
    private lateinit var topAppsAdapter: AppObjectAdapter
    private lateinit var appsAdapter: AppObjectAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = layoutInflater.inflate(R.layout.fragment_home_store, container, false)

        HomeStoreScene.createScene(this)

        topAppsAdapter = AppObjectAdapter(
            requireContext(),
            EnumAppLayoutType.TOP_APP
        )
        appsAdapter = AppObjectAdapter(
            requireContext(),
            EnumAppLayoutType.COMMON_APP
        )
        view.rvTopApps.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        view.rvTopApps.adapter = topAppsAdapter

        view.rvApps.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        view.rvApps.adapter = appsAdapter
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.requestAppList()
    }

    override fun updateAppList(list: List<AppObject>) {
        requireActivity().runOnUiThread {
            topAppsAdapter.swapContent(list)
            appsAdapter.swapContent(list)
            rlHomeFragment.visibility = View.VISIBLE
        }
    }

    override fun onError() {
        rlHomeFragment.visibility = View.VISIBLE
        rlTopApps.visibility = View.GONE
        rlCommonApps.visibility = View.GONE
        tvError.visibility = View.VISIBLE
    }
}
