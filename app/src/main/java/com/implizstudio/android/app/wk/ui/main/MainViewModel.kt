package com.implizstudio.android.app.wk.ui.main

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.implizstudio.android.app.wk.data.model.StockResponse
import com.implizstudio.android.app.wk.data.model.UserResponse
import com.implizstudio.android.app.wk.data.model.constant.Constant
import com.implizstudio.android.app.wk.data.remote.ApiResponse
import com.implizstudio.android.app.wk.data.repository.WarungKuRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(private val warungKuRepository: WarungKuRepository) : ViewModel() {

    val searchQuery = ObservableField<String>()

    private val _onProgressBar = MutableLiveData<Boolean>()
    fun onProgressBar() = _onProgressBar as LiveData<Boolean>?

    private val _getUser = MutableLiveData<UserResponse.User>()
        .also { user ->

        _onProgressBar.value = true
        CoroutineScope(Dispatchers.IO).launch {

            when (val response = warungKuRepository.getUser(Constant.Var.ACCOUNT_LOGIN_ID)) {
                is ApiResponse.Success -> {
                    _onProgressBar.postValue(false)

                    user.postValue(response.body?.user)
                }

                is ApiResponse.Failure -> _onProgressBar.postValue(false)
            }

        }

    }
    fun getUser() = _getUser as LiveData<UserResponse.User>?

    private val _getStocks = MutableLiveData<List<StockResponse.Stock>>()
        .also { fetchStocks() }
    fun getStocks() = _getStocks as LiveData<List<StockResponse.Stock>>?

    fun doSearchStock() { fetchStocks() }

    private fun fetchStocks() {

        _onProgressBar.value = true
        CoroutineScope(Dispatchers.IO).launch {

            when (val response = warungKuRepository.getStocks(searchQuery.get())) {
                is ApiResponse.Success -> {
                    _onProgressBar.postValue(false)

                    _getStocks.postValue(response.body?.stocks)
                }

                is ApiResponse.Failure -> _onProgressBar.postValue(false)
            }

        }

    }

}