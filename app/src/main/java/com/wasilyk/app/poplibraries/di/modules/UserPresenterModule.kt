package com.wasilyk.app.poplibraries.di.modules

import com.wasilyk.app.poplibraries.model.repo.IGithubUsersRepo
import com.wasilyk.app.poplibraries.presenter.UserPresenter
import dagger.Module
import dagger.Provides

@Module
class UserPresenterModule {
    @Provides
    fun provideUserPresenter(login: String, repo: IGithubUsersRepo): UserPresenter =
        UserPresenter(login, repo)
}