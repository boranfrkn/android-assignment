package com.arabam.android.assigment.view

import android.os.Build
import android.os.Bundle
import android.text.Html
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.text.HtmlCompat.FROM_HTML_MODE_COMPACT
import androidx.core.text.HtmlCompat.FROM_HTML_MODE_LEGACY
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.arabam.android.assigment.R
import com.arabam.android.assigment.databinding.FragmentDescriptionBinding
import com.arabam.android.assigment.viewmodel.AdDetailViewModel

private lateinit var dataBinding : FragmentDescriptionBinding
private lateinit var vm: AdDetailViewModel
class DescriptionFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_description,container,false)
        return dataBinding.root
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm = ViewModelProviders.of(this).get(AdDetailViewModel::class.java)
        vm.loadDetail(itemId)
        observeLiveData()
    }
    @RequiresApi(Build.VERSION_CODES.N)
    fun observeLiveData(){
        vm.detail.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            it?.let {
                dataBinding.vari = it
                it.text = Html.fromHtml(it.text, Html.FROM_HTML_MODE_LEGACY).toString()
            }
        })
    }
}