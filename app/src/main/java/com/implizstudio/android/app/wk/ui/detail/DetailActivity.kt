package com.implizstudio.android.app.wk.ui.detail

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.implizstudio.android.app.wk.R
import com.implizstudio.android.app.wk.data.model.constant.Constant
import com.implizstudio.android.app.wk.databinding.ActivityDetailBinding
import com.implizstudio.android.app.wk.ui.base.BaseActivity

class DetailActivity : BaseActivity<ActivityDetailBinding>() {

    private val viewModel by lazy {
        ViewModelProviders.of(this@DetailActivity, viewModelFactory)[DetailViewModel::class.java]
    }

    override fun getContentView(): Int = R.layout.activity_detail

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        val stockId = intent.getStringExtra(Constant.IntentKey.STOCK_ID)

        viewModel.getStockDetail(stockId)?.observe(this@DetailActivity, Observer { stock ->
            binding?.stock = stock
        })

    }

}