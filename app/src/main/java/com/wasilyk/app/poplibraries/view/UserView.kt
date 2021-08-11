package com.wasilyk.app.poplibraries.view

import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface UserView: ScreenView {
    fun showUser(user: GithubUserViewModel)
}