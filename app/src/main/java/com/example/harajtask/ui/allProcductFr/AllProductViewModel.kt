package com.example.harajtask.ui.allProcductFr

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.harajtask.data.repositorys.MainRepository
import com.example.harajtask.domain.ProductModelsItem
import com.example.harajtask.utils.Coroutines
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AllProductViewModel @Inject constructor(private val mainRepository: MainRepository) :
    ViewModel() {

    val listProducts: MutableLiveData<Array<ProductModelsItem>> = MutableLiveData()

    fun getAllproducts() {
        Coroutines.main {
            val res = mainRepository.getAllProduct()
            res.let {
                listProducts.postValue(it)

            }
        }
    }

}