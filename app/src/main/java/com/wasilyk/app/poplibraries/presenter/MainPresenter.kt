package com.wasilyk.app.poplibraries.presenter

import com.github.terrakok.cicerone.Router
import com.wasilyk.app.poplibraries.view.MainView
import com.wasilyk.app.poplibraries.view.UsersScreen
import moxy.MvpPresenter

class MainPresenter(
    private val router: Router
) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.newRootScreen(UsersScreen.create())
    }

    fun back() = router.exit()
}