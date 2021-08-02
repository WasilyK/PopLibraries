package com.wasilyk.app.poplibraries.view

import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.wasilyk.app.poplibraries.model.entity.GithubUser
import com.wasilyk.app.poplibraries.presenter.IScreens

class AndroidScreens: IScreens {
    override fun users(screens: IScreens) = FragmentScreen { UsersFragment.newInstance(screens) }
    override fun user(githubUser: GithubUser?) = FragmentScreen { UserFragment.newInstance(githubUser) }
}