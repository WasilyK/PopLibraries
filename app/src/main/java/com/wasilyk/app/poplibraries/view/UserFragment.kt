package com.wasilyk.app.poplibraries.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.wasilyk.app.poplibraries.databinding.FragmentUserBinding
import com.wasilyk.app.poplibraries.model.entity.GithubUser
import com.wasilyk.app.poplibraries.presenter.UserPresenter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserFragment: MvpAppCompatFragment(), UserView {

    companion object {
        private const val GITHUB_USER_KEY = "github_user_key"

        fun newInstance(user: GithubUser?): Fragment =
            UserFragment().apply { arguments = bundleOf(GITHUB_USER_KEY to user) }
    }

    private var binding: FragmentUserBinding? = null
    private val presenter by moxyPresenter { UserPresenter(arguments?.getParcelable(GITHUB_USER_KEY)) }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)
        = FragmentUserBinding.inflate(inflater, container, false).also {
            binding = it
        }.root

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun showUser(login: String) {
        binding?.tvLogin?.text = login
    }
}