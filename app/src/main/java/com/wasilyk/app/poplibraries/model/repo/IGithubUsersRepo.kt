package com.wasilyk.app.poplibraries.model.repo

import com.wasilyk.app.poplibraries.model.entity.GithubUser
import com.wasilyk.app.poplibraries.model.entity.GithubUserRepo
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Observable

interface IGithubUsersRepo {
    fun getUsers(): Observable<List<GithubUser>>
    fun getUserByLogin(login: String?): Maybe<GithubUser>
    fun getUserRepos(url: String): Observable<List<GithubUserRepo>>
}