package com.wasilyk.app.poplibraries.presenter

import com.github.terrakok.cicerone.Screen
import com.wasilyk.app.poplibraries.model.entity.GithubUser

interface IScreens {
    fun users(screens: IScreens): Screen
    fun user(githubUser: GithubUser?): Screen
}