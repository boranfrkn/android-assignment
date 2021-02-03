package com.arabam.android.assigment.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.arabam.android.assigment.R
import com.arabam.android.assigment.adapter.ListRecyclerViewAdapter
import com.arabam.android.assigment.databinding.FragmentDetailBinding
import kotlinx.android.synthetic.main.fragment_detail.*

var itemId = 0
class DetailFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_detail,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            itemId = DetailFragmentArgs.fromBundle(it).itemId
        }
        childFragmentManager.beginTransaction().replace(R.id.fragmentHolder,AdDetailFragment()).commit()
        bottom_navigation.setOnNavigationItemSelectedListener {menuItem ->
            if(menuItem.itemId == R.id.detailMenu){
                childFragmentManager.beginTransaction().replace(R.id.fragmentHolder,AdDetailFragment()).commit()
            }
            if(menuItem.itemId == R.id.descriptonMenu){
                childFragmentManager.beginTransaction().replace(R.id.fragmentHolder,DescriptionFragment()).commit()
            }
            true
        }
    }
}