package com.example.harajtask.ui.allProcductFr

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.harajtask.R

class AllProductFragment : Fragment() {

    companion object {
        fun newInstance() = AllProductFragment()
    }

    private lateinit var viewModel: AllProductViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.all_product_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AllProductViewModel::class.java)
        // TODO: Use the ViewModel
    }

}