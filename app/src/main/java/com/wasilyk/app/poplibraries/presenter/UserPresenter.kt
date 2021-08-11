package com.wasilyk.app.poplibraries.presenter

import com.wasilyk.app.poplibraries.model.repo.IGithubUsersRepo
import com.wasilyk.app.poplibraries.view.GithubUserViewModel
import com.wasilyk.app.poplibraries.view.UserView
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.plusAssign
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter

class UserPresenter(
    private val login: String?,
    private val repo: IGithubUsersRepo
) : MvpPresenter<UserView>() {

    private val disposables = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        disposables +=
            repo.getUserByLogin(login)
                .observeOn(Schedulers.computation())
                .map { GithubUserViewModel.Mapper.map(it) }
                .defaultIfEmpty(GithubUserViewModel("Unknown", "http://unknown"))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { user -> viewState.showUser(user) },
                    { error -> viewState.showToast(error.message ?: "get user error") }
                )
    }

    override fun onDestroy() {
        disposables.clear()
        super.onDestroy()
    }
}