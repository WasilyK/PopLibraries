package com.wasilyk.app.poplibraries.view

import com.wasilyk.app.poplibraries.model.entity.GithubUser

data class GithubUserViewModel(
    val login: String,
    val avatar_url: String,
    val repos_url: String
) {
    object Mapper {
        fun map(user: GithubUser) = GithubUserViewModel(
            user.login.uppercase(), user.avatar, user.repos_url)
    }
}