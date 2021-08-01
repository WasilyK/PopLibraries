package com.wasilyk.app.poplibraries.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.wasilyk.app.poplibraries.app.App
import com.wasilyk.app.poplibraries.databinding.FragmentUsersBinding
import com.wasilyk.app.poplibraries.model.repo.GithubUsersRepo
import com.wasilyk.app.poplibraries.presenter.BackButtonListener
import com.wasilyk.app.poplibraries.presenter.UsersPresenter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UsersFragment: MvpAppCompatFragment(), UsersView, BackButtonListener {

    companion object {
        fun newInstance() = UsersFragment()
    }

    private var binding: FragmentUsersBinding? = null
    private val presenter by moxyPresenter { UsersPresenter(GithubUsersRepo(), App.instance.router) }
    private var adapter: UsersRVAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentUsersBinding.inflate(inflater, container, false).also {
        binding = it
    }.root

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun init() {
        binding?.rvUsers?.layoutManager = LinearLayoutManager(context)
        adapter = UsersRVAdapter(presenter.usersListPresenter)
        binding?.rvUsers?.adapter = adapter
    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun backPressed() = presenter.backPressed()
}