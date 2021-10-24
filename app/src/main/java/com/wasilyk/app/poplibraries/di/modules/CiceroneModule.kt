package com.wasilyk.app.poplibraries.di.modules

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.wasilyk.app.poplibraries.di.annotations.AppScope
import dagger.Module
import dagger.Provides

@Module
class CiceroneModule {
    var cicerone = Cicerone.create()

    @AppScope
    @Provides
    fun provideNavigatorHolder(): NavigatorHolder = cicerone.getNavigatorHolder()

    @AppScope
    @Provides
    fun provideRouter(): Router = cicerone.router
}