package com.wasilyk.app.poplibraries.presenter

import com.wasilyk.app.poplibraries.model.entity.GithubUser
import com.wasilyk.app.poplibraries.view.UserView
import moxy.MvpPresenter

class UserPresenter(private val githubUser: GithubUser?): MvpPresenter<UserView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.setLogin(githubUser?.login?: "Unknown")
    }
}