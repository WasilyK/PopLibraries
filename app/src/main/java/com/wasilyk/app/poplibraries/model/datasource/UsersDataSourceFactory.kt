package com.wasilyk.app.poplibraries.model.datasource

import com.wasilyk.app.poplibraries.model.api.GithubApiFactory

object UsersDataSourceFactory {
    fun create() = UsersDataSourceImpl(GithubApiFactory.create())
}