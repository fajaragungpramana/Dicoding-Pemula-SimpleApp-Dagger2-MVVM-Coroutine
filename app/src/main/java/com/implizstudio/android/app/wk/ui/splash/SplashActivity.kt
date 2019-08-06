package com.implizstudio.android.app.wk.ui.splash

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.implizstudio.android.app.wk.R
import com.implizstudio.android.app.wk.data.model.constant.Constant
import com.implizstudio.android.app.wk.ui.main.MainActivity
import org.jetbrains.anko.startActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            startActivity<MainActivity>()
            finish()
        }, Constant.Var.SPLASH_DELAY)

    }

}