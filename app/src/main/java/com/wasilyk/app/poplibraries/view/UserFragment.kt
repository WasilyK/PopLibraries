package com.wasilyk.app.poplibraries.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.wasilyk.app.poplibraries.databinding.FragmentUserBinding
import com.wasilyk.app.poplibraries.model.repo.GithubUsersRepoFactory
import com.wasilyk.app.poplibraries.presenter.UserPresenter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserFragment: MvpAppCompatFragment(), UserView {

    companion object {
        private const val GITHUB_USER_LOGIN_KEY = "github_user_login_key"

        fun newInstance(login: String): Fragment =
            UserFragment().apply { arguments = bundleOf(GITHUB_USER_LOGIN_KEY to login) }
    }

    private var binding: FragmentUserBinding? = null
    private val presenter by moxyPresenter { UserPresenter(
        arguments?.getString(GITHUB_USER_LOGIN_KEY), GithubUsersRepoFactory.create()) }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)
        = FragmentUserBinding.inflate(inflater, container, false).also {
            binding = it
        }.root

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

    override fun showUser(user: GithubUserViewModel) {
        binding?.apply {
            tvLogin.text = user.login
            tvLogin.setStartDrawableCircleImageFromUri(user.avatar_url)
        }

    }

    override fun showToast(message: String) {
        Toast.makeText(requireActivity(), message, Toast.LENGTH_LONG).show()
    }
}