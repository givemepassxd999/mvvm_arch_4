@file:Suppress("DEPRECATION")

package com.sample.demo.myapplication

import android.app.ProgressDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {
    private val infoViewModel: InfoViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dialog = ProgressDialog.show(
            this, "",
            "Loading. Please wait...", true
        )
        dialog.hide()
        infoViewModel.userInfoLiveData.observe(this, Observer {
            info.text = it
        })
        send_data.setOnClickListener {
            infoViewModel.callInfo()
        }
        infoViewModel.loading.observe(this, Observer { loading ->
            if (loading) {
                dialog.show()
            } else {
                dialog.hide()
            }
        })
    }
}
