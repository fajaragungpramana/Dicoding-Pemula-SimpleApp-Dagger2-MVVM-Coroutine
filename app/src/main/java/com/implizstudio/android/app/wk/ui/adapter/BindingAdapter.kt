package com.implizstudio.android.app.wk.ui.adapter

import android.annotation.SuppressLint
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.implizstudio.android.app.wk.R
import com.implizstudio.android.app.wk.extension.gone
import com.implizstudio.android.app.wk.extension.visible
import com.squareup.picasso.Picasso
import java.text.NumberFormat
import java.util.*

object BindingAdapter {

    @JvmStatic
    @BindingAdapter("onProgressBar")
    fun onProgressBar(view: View, visibility: Boolean?) {
        if (visibility!!) view.visible() else view.gone()
    }

    @JvmStatic
    @BindingAdapter("displayPhotoStock", "displayPhotoUser", requireAll = false)
    fun displayPhoto(imageView: ImageView, photoStock: String?, photoUser: String?) {

        when {
            photoStock != null -> loadWithPicasso(imageView, photoStock, R.drawable.ic_no_photo)
            photoUser != null -> loadWithPicasso(imageView, photoUser, R.drawable.ic_default_person)
        }

    }

    @SuppressLint("SetTextI18n")
    @JvmStatic
    @BindingAdapter("displayCurrency")
    fun displayCurrency(textView: TextView, amount: String?) {

        if (amount != null) {

            val symbol = Currency.getInstance(Locale.getDefault()).symbol
            val format = NumberFormat.getInstance().format(amount.toLong())

            textView.text = "$symbol $format"

        }
    }

    @SuppressLint("SetTextI18n")
    @JvmStatic
    @BindingAdapter("displaySoldPCS", "displaySoldSTD", "displaySoldBOX", requireAll = false)
    fun displaySoldOut(textView: TextView, pcs: String?, std: String?, box: String?) {
        when {
            pcs != null -> textView.text = "$pcs PCS"
            std != null -> textView.text = "$std STD"
            box != null -> textView.text = "$box BOX"
        }
    }

    @SuppressLint("SetTextI18n")
    @JvmStatic
    @BindingAdapter("displayExp")
    fun displayExp(textView: TextView, exp: String?) {
        textView.text = "$exp XP"
    }

    @SuppressLint("SetTextI18n")
    @JvmStatic
    @BindingAdapter("purchasePrice", "sellPrice")
    fun countProfit(textView: TextView, purchasePrice: String?, sellPrice: String?) {
        if (purchasePrice != null && sellPrice != null) {

            val profit = sellPrice.toDouble() - purchasePrice.toDouble()
            val profitPercentage = profit / purchasePrice.toDouble() * 100.0

            textView.text = "+${profitPercentage.toInt()}%"

        }
    }

    @SuppressLint("SetTextI18n")
    @JvmStatic
    @BindingAdapter("displayFirstName", "displayLastName", requireAll = false)
    fun displayName(textView: TextView, firstName: String?, lastName: String?) {
        when {
            firstName != null && lastName != null -> textView.text = "$firstName $lastName"
            firstName != null -> textView.text = "Hello, $firstName"
            lastName != null -> textView.text = lastName
        }
    }

    private fun loadWithPicasso(imageView: ImageView, photoUrl: String?, error: Int) {
        Picasso.get()
            .load(photoUrl)
            .placeholder(error)
            .error(error)
            .into(imageView)
    }

}