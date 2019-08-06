package com.implizstudio.android.app.wk.di.module.builder

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.implizstudio.android.app.wk.di.scope.ViewModelKey
import com.implizstudio.android.app.wk.ui.about.AboutViewModel
import com.implizstudio.android.app.wk.ui.detail.DetailViewModel
import com.implizstudio.android.app.wk.ui.main.MainViewModel
import com.implizstudio.android.app.wk.util.ViewModelFactoryUtil
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelBuilder {

    @Binds
    internal abstract fun bindViewModelFactory(viewModelFactoryUtil: ViewModelFactoryUtil): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    internal abstract fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AboutViewModel::class)
    internal abstract fun bindAboutViewModel(aboutViewModel: AboutViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailViewModel::class)
    internal abstract fun bindDetailViewModel(detailViewModel: DetailViewModel): ViewModel

}