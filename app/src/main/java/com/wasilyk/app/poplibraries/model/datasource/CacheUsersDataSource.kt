package com.wasilyk.app.poplibraries.model.datasource

import com.wasilyk.app.poplibraries.model.entity.GithubUser
import com.wasilyk.app.poplibraries.model.entity.GithubUserRepo
import io.reactivex.rxjava3.core.Single

interface CacheUsersDataSource : UsersDataSource {
    fun retain(users: List<GithubUser>): Single<List<GithubUser>>
    fun retain(user: GithubUser): Single<GithubUser>
    fun retainRepos(userRepos: List<GithubUserRepo>, userId: String): Single<List<GithubUserRepo>>
    fun getUserIdByReposUrl(url: String): String
}