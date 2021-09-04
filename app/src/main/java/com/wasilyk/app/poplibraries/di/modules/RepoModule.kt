package com.wasilyk.app.poplibraries.di.modules

import com.wasilyk.app.poplibraries.model.datasource.CacheUsersDataSource
import com.wasilyk.app.poplibraries.model.datasource.UsersDataSource
import com.wasilyk.app.poplibraries.model.repo.GithubUsersRepo
import com.wasilyk.app.poplibraries.model.repo.IGithubUsersRepo
import dagger.Module
import dagger.Provides

@Module
class RepoModule {

    @Provides
    fun provideIGithubUsersRepo(
        usersDataSource: UsersDataSource,
        cacheUsersDataSource: CacheUsersDataSource
    ): IGithubUsersRepo = GithubUsersRepo(usersDataSource, cacheUsersDataSource)
}