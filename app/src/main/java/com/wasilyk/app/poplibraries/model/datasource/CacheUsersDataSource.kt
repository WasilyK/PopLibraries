package com.wasilyk.app.poplibraries.model.datasource

import com.wasilyk.app.poplibraries.model.entity.GithubUser
import io.reactivex.rxjava3.core.Single

interface CacheUsersDataSource : UsersDataSource {
    fun retain(users: List<GithubUser>): Single<List<GithubUser>>
    fun retain(user: GithubUser): Single<GithubUser>
}