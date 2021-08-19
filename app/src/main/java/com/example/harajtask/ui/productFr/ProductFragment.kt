package com.example.harajtask.ui.productFr

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.harajtask.databinding.ProductFragmentBinding
import com.example.harajtask.domain.ProductModelsItem
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductFragment : Fragment() {


    private val viewModel: ProductViewModel by viewModels()
    private var _binding: ProductFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding =
            ProductFragmentBinding.inflate(LayoutInflater.from(inflater.context), container, false)

        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()

        with(viewModel) {
            showProduct(arguments?.getInt("id"))
            productItem.observe(requireActivity(), {
                setData(it)
            })
        }







        return binding.root
    }

    private fun setData(item: ProductModelsItem) {


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            binding.txtBody.text = Html.fromHtml(item.body, Html.FROM_HTML_MODE_LEGACY)
        } else {
            binding.txtBody.text = Html.fromHtml(item.body)
        }


        binding.txtTitle.text = item.title
        binding.txtUserName.text = item.username
        binding.txtLocations.text = item.city
        Glide
            .with(binding.root)
            .load(item.thumbURL)
            .centerCrop()
            .into(binding.inmgProduct)

        binding.txtTime.text = viewModel.convertLongtotime(item.date.toLong())

        binding.imsShare.setOnClickListener {
            val intent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TITLE, item.title)
                type = "text/plain"

            }

            val shredIntent = Intent.createChooser(intent, null)
            requireActivity().startActivity(shredIntent)


        }

    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}