package com.wasilyk.app.poplibraries.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.wasilyk.app.poplibraries.databinding.FragmentUserBinding
import com.wasilyk.app.poplibraries.model.entity.GithubUser
import com.wasilyk.app.poplibraries.presenter.UserPresenter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserFragment: MvpAppCompatFragment(), UserView {

    companion object {
        private const val GITHUB_USER_KEY = "github_user_key"

        fun newInstance(githubUser: GithubUser?): UserFragment {
            val bundle = Bundle().also { it.putParcelable(GITHUB_USER_KEY, githubUser) }
            return UserFragment().also { it.arguments = bundle }
        }
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

    override fun setLogin(login: String) {
        binding?.tvLogin?.text = login
    }
}