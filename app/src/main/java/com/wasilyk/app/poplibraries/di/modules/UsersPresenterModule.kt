package com.wasilyk.app.poplibraries.di.modules

import com.github.terrakok.cicerone.Router
import com.wasilyk.app.poplibraries.model.repo.IGithubUsersRepo
import com.wasilyk.app.poplibraries.presenter.UsersPresenter
import dagger.Module
import dagger.Provides

@Module
class UsersPresenterModule {
    @Provides
    fun provideUsersPresenter(
        repo: IGithubUsersRepo,
        router: Router
    ): UsersPresenter = UsersPresenter(repo, router)
}