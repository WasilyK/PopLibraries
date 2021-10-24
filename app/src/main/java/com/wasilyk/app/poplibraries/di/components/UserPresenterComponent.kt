package com.wasilyk.app.poplibraries.di.components

import com.wasilyk.app.poplibraries.di.modules.UserPresenterModule
import com.wasilyk.app.poplibraries.presenter.UserPresenter
import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent(modules = [UserPresenterModule::class])
interface UserPresenterComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance login: String): UserPresenterComponent
    }

    fun getUserPresenter(): UserPresenter
}