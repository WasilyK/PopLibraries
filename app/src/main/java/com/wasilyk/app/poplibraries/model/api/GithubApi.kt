package com.wasilyk.app.poplibraries.model.api

import com.wasilyk.app.poplibraries.model.entity.GithubUser
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubApi {

    @GET("/users")
    fun getUsers(@Query("since") since: Int? = null): Single<List<GithubUser>>

    @GET("/users/{username}")
    fun getUserByLogin(@Path("username") login: String): Single<GithubUser>
}