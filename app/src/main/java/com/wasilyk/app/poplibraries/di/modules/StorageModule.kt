package com.wasilyk.app.poplibraries.di.modules

import android.content.Context
import com.wasilyk.app.poplibraries.di.annotations.AppScope
import com.wasilyk.app.poplibraries.model.storage.GithubStorage
import com.wasilyk.app.poplibraries.model.storage.GithubStorageFactory
import dagger.Module
import dagger.Provides

@Module
class StorageModule {
    @Provides
    @AppScope
    fun provideStorage(context: Context): GithubStorage = GithubStorageFactory.create(context)
}