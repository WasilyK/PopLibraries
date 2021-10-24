package com.wasilyk.app.poplibraries.di.modules

import com.github.terrakok.cicerone.Router
import com.wasilyk.app.poplibraries.presenter.MainPresenter
import dagger.Module
import dagger.Provides

@Module
class MainPresenterModule {

    @Provides
    fun provideMainPresenter(router: Router): MainPresenter = MainPresenter(router)
}