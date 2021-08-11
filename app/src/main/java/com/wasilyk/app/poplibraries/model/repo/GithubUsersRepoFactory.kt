package com.wasilyk.app.poplibraries.model.repo

import com.wasilyk.app.poplibraries.model.datasource.CacheUsersDataSourceFactory
import com.wasilyk.app.poplibraries.model.datasource.UsersDataSourceFactory

object GithubUsersRepoFactory {
    fun create(): IGithubUsersRepo = GithubUsersRepo(
        UsersDataSourceFactory.create(),
        CacheUsersDataSourceFactory.create())
}