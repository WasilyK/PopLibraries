package com.wasilyk.app.poplibraries.view

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.wasilyk.app.poplibraries.presenter.IScreens

class AndroidScreens: IScreens {
    override fun users() = FragmentScreen { UsersFragment.newInstance() }
}