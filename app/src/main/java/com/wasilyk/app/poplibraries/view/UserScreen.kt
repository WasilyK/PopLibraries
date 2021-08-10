package com.wasilyk.app.poplibraries.view

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.wasilyk.app.poplibraries.model.entity.GithubUser

class UserScreen(private val githubUser: GithubUser?) {
    fun create() = FragmentScreen { UserFragment.newInstance(githubUser) }
}