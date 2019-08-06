package com.implizstudio.android.app.wk.ui.adapter

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.implizstudio.android.app.wk.R
import com.implizstudio.android.app.wk.data.model.StockResponse
import com.implizstudio.android.app.wk.data.model.constant.Constant
import com.implizstudio.android.app.wk.databinding.AdapterStockBinding
import com.implizstudio.android.app.wk.ui.base.BaseAdapter
import com.implizstudio.android.app.wk.ui.detail.DetailActivity
import org.jetbrains.anko.startActivity

class StockAdapter(private val context: Context, private val listStock: List<StockResponse.Stock>)
    : BaseAdapter<AdapterStockBinding, StockAdapter.ViewHolder, StockResponse.Stock>(context, listStock) {

    override fun getContentView(): Int = R.layout.adapter_stock

    override fun getViewHolder(ui: View): ViewHolder = ViewHolder(ui)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) { holder.bindItem(listStock[position]) }

    inner class ViewHolder(private val ui: View) : RecyclerView.ViewHolder(ui) {

        fun bindItem(stock: StockResponse.Stock) {
            binding?.stock = stock

            ui.setOnClickListener { context.startActivity<DetailActivity>(Constant.IntentKey.STOCK_ID to stock.id) }

        }

    }

}