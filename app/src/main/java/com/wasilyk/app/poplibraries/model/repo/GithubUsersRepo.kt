package com.wasilyk.app.poplibraries.model.repo

import com.wasilyk.app.poplibraries.model.datasource.CacheUsersDataSource
import com.wasilyk.app.poplibraries.model.datasource.UsersDataSource
import com.wasilyk.app.poplibraries.model.entity.GithubUser
import com.wasilyk.app.poplibraries.model.entity.GithubUserRepo
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

class GithubUsersRepo(
    private val usersDataSource: UsersDataSource,
    private val cacheUsersDataSource: CacheUsersDataSource
) : IGithubUsersRepo {

    override fun getUsers(): Observable<List<GithubUser>> =
        Observable.concat(
            cacheUsersDataSource.getUsers().toObservable(),
            usersDataSource.getUsers().flatMap(cacheUsersDataSource::retain).toObservable()
        ).subscribeOn(Schedulers.io())

    override fun getUserByLogin(login: String?): Maybe<GithubUser> =
        cacheUsersDataSource.getUserByLogin(login)
            .switchIfEmpty(usersDataSource.getUserByLogin(login))
            .subscribeOn(Schedulers.io())

    override fun getUserRepos(url: String): Maybe<List<GithubUserRepo>> =
        usersDataSource.getUserRepos(url)
}