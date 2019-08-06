package com.implizstudio.android.app.wk.ui.base

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

/**
 * @param<B> - Mean layout binding
 */
abstract class BaseActivity<B: ViewDataBinding> : DaggerAppCompatActivity() {

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory

    protected var binding: B? = null

    protected abstract fun getContentView(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView<B>(this@BaseActivity, getContentView())
            .apply { lifecycleOwner = this@BaseActivity }

        onActivityCreated(savedInstanceState)

    }

    protected abstract fun onActivityCreated(savedInstanceState: Bundle?)

}