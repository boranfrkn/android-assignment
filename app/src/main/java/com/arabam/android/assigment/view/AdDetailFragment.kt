package com.arabam.android.assigment.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.arabam.android.assigment.R
import com.arabam.android.assigment.databinding.FragmentAdDetailBinding
import com.arabam.android.assigment.viewmodel.AdDetailViewModel

var text = ""
class AdDetailFragment : Fragment() {
    private lateinit var viewModel : AdDetailViewModel
    private lateinit var dataBinding : FragmentAdDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        dataBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_ad_detail,container,false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AdDetailViewModel::class.java)
        viewModel.loadDetail(itemId)
        observeLiveData()
    }




    fun observeLiveData(){
        viewModel.detail.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            it?.let {
                dataBinding.detail = it
                text = it.text
            }
        })
    }
}