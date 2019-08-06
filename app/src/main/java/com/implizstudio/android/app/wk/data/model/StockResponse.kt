package com.implizstudio.android.app.wk.data.model

import com.google.gson.annotations.SerializedName

data class StockResponse(
    @SerializedName("stocks") val stocks: List<Stock>,
    @SerializedName("stock") val stock: Stock
) {

    data class Stock (
        @SerializedName("id") val id: String?,
        @SerializedName("created") val created: String?,
        @SerializedName("photo") val photo: String?,
        @SerializedName("soldOutPCS") val soldOutPCS: String?,
        @SerializedName("soldOutSTD") val soldOutSTD: String?,
        @SerializedName("soldOutBOX") val soldOutBOX: String?,
        @SerializedName("name") val name: String?,
        @SerializedName("purchasePricePCS") val purchasePricePCS: String?,
        @SerializedName("purchasePriceSTD") val purchasePriceSTD: String?,
        @SerializedName("purchasePriceBOX") val purchasePriceBOX: String?,
        @SerializedName("sellPricePCS") val sellPricePCS: String?,
        @SerializedName("sellPriceSTD") val sellPriceSTD: String?,
        @SerializedName("sellPriceBOX") val sellPriceBOX: String?,
        @SerializedName("stockTotalPCS") val stockTotalPCS: String?,
        @SerializedName("stockTotalSTD") val stockTotalSTD: String?,
        @SerializedName("stockTotalBOX") val stockTotalBOX: String?,
        @SerializedName("category") val category: String?
    )

}
