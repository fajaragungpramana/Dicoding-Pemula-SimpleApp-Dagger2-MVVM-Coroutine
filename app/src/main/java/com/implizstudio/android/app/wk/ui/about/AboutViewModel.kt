package com.implizstudio.android.app.wk.ui.about

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.implizstudio.android.app.wk.data.model.UserResponse
import com.implizstudio.android.app.wk.data.model.constant.Constant
import com.implizstudio.android.app.wk.data.remote.ApiResponse
import com.implizstudio.android.app.wk.data.repository.WarungKuRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class AboutViewModel @Inject constructor(private val warungKuRepository: WarungKuRepository) : ViewModel() {

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

}