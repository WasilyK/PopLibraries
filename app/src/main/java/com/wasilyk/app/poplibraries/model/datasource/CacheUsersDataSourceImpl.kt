package com.wasilyk.app.poplibraries.model.datasource

import com.wasilyk.app.poplibraries.model.entity.GithubUser
import com.wasilyk.app.poplibraries.model.entity.GithubUserRepo
import com.wasilyk.app.poplibraries.model.storage.GithubStorage
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single

class CacheUsersDataSourceImpl(private val githubStorage: GithubStorage): CacheUsersDataSource {

    override fun retain(users: List<GithubUser>): Single<List<GithubUser>> =
        githubStorage
            .githubUserDao()
            .retain(users)
            .andThen(getUsers())

    override fun retain(user: GithubUser): Single<GithubUser> =
        githubStorage
            .githubUserDao()
            .retain(user)
            .andThen(getUserByLogin(user.login))
            .toSingle()

    override fun getUsers(): Single<List<GithubUser>> =
        githubStorage
            .githubUserDao()
            .fetchUsers()

    override fun getUserByLogin(login: String?): Maybe<GithubUser> =
        githubStorage
            .githubUserDao()
            .fetchUserByLogin(login)

    override fun getUserRepos(url: String): Maybe<List<GithubUserRepo>> = Maybe.empty()
}