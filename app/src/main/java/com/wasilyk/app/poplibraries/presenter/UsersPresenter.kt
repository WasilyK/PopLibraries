package com.wasilyk.app.poplibraries.presenter

import com.github.terrakok.cicerone.Router
import com.wasilyk.app.poplibraries.model.entity.GithubUser
import com.wasilyk.app.poplibraries.model.repo.GithubUsersRepo
import com.wasilyk.app.poplibraries.view.UserItemView
import com.wasilyk.app.poplibraries.view.UserScreen
import com.wasilyk.app.poplibraries.view.UsersView
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter

class UsersPresenter(
    private val usersRepo: GithubUsersRepo,
    private val router: Router
) : MvpPresenter<UsersView>() {

    val disposables: CompositeDisposable = CompositeDisposable()

    class UsersListPresenter : IUserListPresenter {
        val users = mutableListOf<GithubUser>()
        override var itemClickListener: ((UserItemView) -> Unit)? = null
        override fun getCount() = users.size
        override fun bindView(view: UserItemView) {
            val user = users[view.pos]
            view.setLogin(user.login)
        }
    }

    val usersListPresenter = UsersListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()

        usersListPresenter.itemClickListener = { itemView ->
            val user = usersListPresenter.users[itemView.pos]
            router.navigateTo(UserScreen(user).create())
        }
    }

    private fun loadData() {
        val disposable = usersRepo.getUsers().subscribe (
            { users -> usersListPresenter.users.addAll(users) },
            { _ -> return@subscribe }
        )
        disposables.add(disposable)
        viewState.updateList()
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        disposables.dispose()
    }
}