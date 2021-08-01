package com.wasilyk.app.poplibraries.view

import android.os.Bundle
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.wasilyk.app.poplibraries.R
import com.wasilyk.app.poplibraries.app.App
import com.wasilyk.app.poplibraries.databinding.ActivityMainBinding
import com.wasilyk.app.poplibraries.presenter.BackButtonListener
import com.wasilyk.app.poplibraries.presenter.MainPresenter
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity : MvpAppCompatActivity(), MainView {

    private var binding: ActivityMainBinding? = null
    private val presenter by moxyPresenter { MainPresenter(App.instance.router, AndroidScreens()) }
    private val navigator = AppNavigator(this, R.id.container)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        App.instance.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        App.instance.navigatorHolder.removeNavigator()
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach {
            if(it is BackButtonListener && it.backPressed()) {
                return
            }
        }
        presenter.backClicked()
    }
}