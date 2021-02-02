package com.arabam.android.assigment.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.arabam.android.assigment.R
import com.arabam.android.assigment.adapter.ListRecyclerViewAdapter
import com.arabam.android.assigment.viewmodel.AdListViewModel
import kotlinx.android.synthetic.main.fragment_list.*

class ListFragment : Fragment() {

    private lateinit var viewModel : AdListViewModel
    private val recyclerViewListAdapter = ListRecyclerViewAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AdListViewModel::class.java)
        viewModel.loadData()
        listRecyclerView.apply {
            listRecyclerView.layoutManager = LinearLayoutManager(context)
            listRecyclerView.adapter = recyclerViewListAdapter
            setHasFixedSize(true)
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }
        observeLiveData()
    }


    fun observeLiveData(){
        viewModel.list.observe(viewLifecycleOwner, Observer {list ->
            list?.let {
                recyclerViewListAdapter.adListUpdate(list)
            }
        })
    }

}