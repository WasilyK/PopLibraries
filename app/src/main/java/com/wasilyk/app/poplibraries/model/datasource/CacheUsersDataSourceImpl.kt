package com.wasilyk.app.poplibraries.model.datasource

import com.wasilyk.app.poplibraries.model.entity.GithubUser
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single

class CacheUsersDataSourceImpl: CacheUsersDataSource {

    private val cache = mutableListOf<GithubUser>()

    override fun retain(users: List<GithubUser>): Single<List<GithubUser>> =
        Single.fromCallable {
            cache.clear()
            cache.also { it.addAll(users) }
        }
    override fun retain(user: GithubUser): Single<GithubUser> =
        Single.fromCallable { user }

    override fun getUsers(): Single<List<GithubUser>> = Single.just(cache)

    override fun getUserByLogin(login: String?): Maybe<GithubUser> =
        Maybe.defer {
            cache.firstOrNull { user -> user.login.contentEquals(login, true) }
                ?.let { user -> Maybe.just(user) }
                ?: Maybe.empty()
        }
}