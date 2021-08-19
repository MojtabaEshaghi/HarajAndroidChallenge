package com.example.harajtask.ui.productFr

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.harajtask.data.repositorys.MainRepository
import com.example.harajtask.domain.ProductModelsItem
import com.example.harajtask.utils.Coroutines
import dagger.hilt.android.lifecycle.HiltViewModel
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(private val mainRepository: MainRepository) :
    ViewModel() {

    val productItem: MutableLiveData<ProductModelsItem> = MutableLiveData()

    fun showProduct(id: Int?) {
        id?.let {

            Coroutines.main {
                mainRepository.getAllProduct()[it].let {
                    productItem.postValue(it)
                }
            }
        }

    }


    fun convertLongtotime(time: Long): String {
        val date = Date(time)
        val format = SimpleDateFormat("yyyy.mm.dd HH:mm aa")
        return format.format(date)
    }

}