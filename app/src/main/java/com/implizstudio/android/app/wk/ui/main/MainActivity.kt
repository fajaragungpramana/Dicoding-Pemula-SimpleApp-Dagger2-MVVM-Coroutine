package com.implizstudio.android.app.wk.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.implizstudio.android.app.wk.R
import com.implizstudio.android.app.wk.data.model.constant.Constant
import com.implizstudio.android.app.wk.databinding.ActivityMainBinding
import com.implizstudio.android.app.wk.ui.about.AboutActivity
import com.implizstudio.android.app.wk.ui.adapter.StockAdapter
import com.implizstudio.android.app.wk.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.intentFor

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val viewModel by lazy {
        ViewModelProviders.of(this@MainActivity, viewModelFactory)[MainViewModel::class.java]
    }

    override fun getContentView(): Int = R.layout.activity_main

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        binding?.viewModel = viewModel

        cv_to_about.setOnClickListener {
            startActivity(intentFor<AboutActivity>().addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
        }

        rv_stock.layoutManager = StaggeredGridLayoutManager(Constant.Var.STAGGERED_NUM_COLUMN, LinearLayoutManager.VERTICAL)

        viewModel.getUser()?.observe(this@MainActivity, Observer { user ->
            binding?.user = user
        })

        viewModel.getStocks()?.observe(this@MainActivity, Observer { stocks ->
            rv_stock.adapter = StockAdapter(this@MainActivity, stocks)
        })

    }

}