package com.wasilyk.app.poplibraries.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wasilyk.app.poplibraries.databinding.ActivityMainBinding
import com.wasilyk.app.poplibraries.presenter.MainPresenter

class MainActivity : AppCompatActivity(), MainView {

    private var binding: ActivityMainBinding? = null
    private val presenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.btnCounter1?.setOnClickListener { presenter.counterButton1Click() }
        binding?.btnCounter2?.setOnClickListener { presenter.counterButton2Click() }
        binding?.btnCounter3?.setOnClickListener { presenter.counterButton3Click() }
    }

    override fun setButton1Text(text: String) { binding?.btnCounter1?.text = text }
    override fun setButton2Text(text: String) { binding?.btnCounter2?.text = text }
    override fun setButton3Text(text: String) { binding?.btnCounter3?.text = text }
}