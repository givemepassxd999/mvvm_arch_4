@file:Suppress("DEPRECATION")

package com.sample.demo.myapplication

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {

    private val infoViewModel by viewModel<InfoViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dialog = ProgressbarFragment.newInstance(getString(R.string.uploading))
        infoViewModel.getUserInfo().observe(this, Observer { infoText ->
            info.text = infoText
        })
        send_data.setOnClickListener {
            infoViewModel.callInfo()
        }
        infoViewModel.loading.observe(this, Observer { loading ->
            if (loading) {
                progress.visibility = View.VISIBLE
            } else {
                progress.visibility = View.GONE
            }
        })
    }
}
