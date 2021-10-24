package com.wasilyk.app.poplibraries.model.api

import com.wasilyk.app.poplibraries.BuildConfig.GITHUB_USER_NAME
import com.wasilyk.app.poplibraries.BuildConfig.GITHUB_USER_PASS
import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.Response

object GithubApiInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response =
        chain.proceed(
            chain.request()
                .newBuilder()
                .header("Authorization", Credentials.basic(GITHUB_USER_NAME, GITHUB_USER_PASS))
                .build()
        )
}