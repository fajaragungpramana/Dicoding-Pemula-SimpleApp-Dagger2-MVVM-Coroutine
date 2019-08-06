package com.implizstudio.android.app.wk.ui.base

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
 * @param<B> - mean layout binding
 * @param<H> - mean recycler view holder adapter
 * @param<M> - mean listModel
 */
abstract class BaseAdapter<B: ViewDataBinding, H: RecyclerView.ViewHolder, M>
    (private val context: Context, private val listModel: List<M>) : RecyclerView.Adapter<H>() {

    protected var binding: B? = null

    protected abstract fun getContentView(): Int
    protected abstract fun getViewHolder(ui: View): H

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): H {
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), getContentView(), parent, false)
        return getViewHolder(binding?.root!!)
    }

    override fun getItemCount(): Int = listModel.size

    override fun onBindViewHolder(holder: H, position: Int) { /* TODO: Implemented on Subclass */ }

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getItemViewType(position: Int): Int = position

}