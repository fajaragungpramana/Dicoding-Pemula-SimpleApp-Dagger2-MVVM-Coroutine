package com.implizstudio.android.app.wk.ui.about

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.implizstudio.android.app.wk.R
import com.implizstudio.android.app.wk.databinding.ActivityAboutBinding
import com.implizstudio.android.app.wk.ui.base.BaseActivity
import com.implizstudio.android.app.wk.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_about.*
import org.jetbrains.anko.startActivity

class AboutActivity : BaseActivity<ActivityAboutBinding>() {

    private val viewModel by lazy {
        ViewModelProviders.of(this@AboutActivity, viewModelFactory)[AboutViewModel::class.java]
    }

    override fun getContentView(): Int = R.layout.activity_about

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        binding?.viewModel = viewModel

        iv_icon_back.setOnClickListener {
            startActivity<MainActivity>()
            finish()
        }

        viewModel.getUser()?.observe(this@AboutActivity, Observer { user ->
            binding?.user = user
        })

    }

}