package com.wasilyk.app.poplibraries.di.components

import android.content.Context
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.wasilyk.app.poplibraries.di.annotations.AppScope
import com.wasilyk.app.poplibraries.di.modules.*
import com.wasilyk.app.poplibraries.model.api.GithubApi
import com.wasilyk.app.poplibraries.model.datasource.*
import com.wasilyk.app.poplibraries.model.repo.IGithubUsersRepo
import com.wasilyk.app.poplibraries.model.storage.GithubStorage
import com.wasilyk.app.poplibraries.presenter.MainPresenter
import com.wasilyk.app.poplibraries.presenter.UsersPresenter
import dagger.BindsInstance
import dagger.Component

@AppScope
@Component(
    modules = [
        ApiModule::class,
        CiceroneModule::class,
        DatasourceModule::class,
        MainPresenterModule::class,
        RepoModule::class,
        StorageModule::class,
        UsersPresenterModule::class]
)
interface AppComponent {

    @Component.Factory
    interface AppComponentFactory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun getGithubApi(): GithubApi

    @AppScope
    fun getNavigatorHolder(): NavigatorHolder

    @AppScope
    fun getRouter(): Router

    fun getCacheUsersDataSource(): CacheUsersDataSource

    fun getRoomGithubReposCache(): RoomGithubReposCache

    fun getRoomGithubUsersCache(): RoomGithubUsersCache

    fun getUsersDataSource(): UsersDataSource

    fun getMainPresenter(): MainPresenter

    fun getIGithubUsersRepo(): IGithubUsersRepo

    fun getStorage(): GithubStorage

    fun getUsersPresenter(): UsersPresenter

    fun getUserPresCompFactory(): UserPresenterComponent.Factory
}