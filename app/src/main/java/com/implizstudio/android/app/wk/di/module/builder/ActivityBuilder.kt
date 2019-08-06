package com.implizstudio.android.app.wk.di.module.builder

import com.implizstudio.android.app.wk.ui.about.AboutActivity
import com.implizstudio.android.app.wk.ui.detail.DetailActivity
import com.implizstudio.android.app.wk.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(
    includes = [
        ViewModelBuilder::class
    ]
)
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    internal abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector
    internal abstract fun contributeAboutActivity(): AboutActivity

    @ContributesAndroidInjector
    internal abstract fun contributeDetailActivity(): DetailActivity

}