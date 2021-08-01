package com.wasilyk.app.poplibraries.presenter

import com.github.terrakok.cicerone.Router
import com.wasilyk.app.poplibraries.view.MainView
import moxy.MvpPresenter

class MainPresenter(private val router: Router, val screens: IScreens): MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(screens.users())
    }

    fun backClicked() {
        router.exit()
    }
}