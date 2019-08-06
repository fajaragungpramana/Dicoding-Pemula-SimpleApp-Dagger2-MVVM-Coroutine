package com.implizstudio.android.app.wk.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.implizstudio.android.app.wk.data.model.StockResponse
import com.implizstudio.android.app.wk.data.remote.ApiResponse
import com.implizstudio.android.app.wk.data.repository.WarungKuRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailViewModel @Inject constructor(private val warungKuRepository: WarungKuRepository) : ViewModel() {

    private val _getStockDetail = MutableLiveData<StockResponse.Stock>()
    fun getStockDetail(stockId: String?): LiveData<StockResponse.Stock>? {

        CoroutineScope(Dispatchers.IO).launch {

            when (val response = warungKuRepository.getStockDetail(stockId)) {
                is ApiResponse.Success -> _getStockDetail.postValue(response.body?.stock)
                is ApiResponse.Failure -> {}
            }

        }

        return _getStockDetail
    }

}