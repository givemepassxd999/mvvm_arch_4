package com.sample.demo.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.fragment_progressbar.*

class ProgressbarFragment : DialogFragment() {
    private lateinit var title: String

    companion object {
        const val TITLE = "title"
        fun newInstance(title: String): ProgressbarFragment {
            val fragment = ProgressbarFragment()
            val args = Bundle().apply {
                putString(TITLE, title)
            }
            fragment.arguments = args
            return fragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        info_text.text = title
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_progressbar, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.run {
            title = getString(TITLE, "")
        }
    }
}