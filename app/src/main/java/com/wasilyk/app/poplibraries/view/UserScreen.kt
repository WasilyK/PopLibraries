package com.wasilyk.app.poplibraries.view

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.wasilyk.app.poplibraries.model.entity.GithubUser

class UserScreen(private val login: String) {
    fun create() = FragmentScreen { UserFragment.newInstance(login) }
}