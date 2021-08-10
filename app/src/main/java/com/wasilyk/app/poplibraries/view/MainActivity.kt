package com.wasilyk.app.poplibraries.view

import android.os.Bundle
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.wasilyk.app.poplibraries.R
import com.wasilyk.app.poplibraries.app.App.Navigation.navigatorHolder
import com.wasilyk.app.poplibraries.app.App.Navigation.router
import com.wasilyk.app.poplibraries.databinding.ActivityMainBinding
import com.wasilyk.app.poplibraries.presenter.BackButtonListener
import com.wasilyk.app.poplibraries.presenter.MainPresenter
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity : MvpAppCompatActivity(), MainView {

    private var binding: ActivityMainBinding? = null
    private val presenter by moxyPresenter { MainPresenter(router) }
    private val navigator = AppNavigator(this, R.id.container)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach {
            if(it is BackButtonListener && it.backPressed()) {
                return
            }
        }
        presenter.back()
    }
}