package com.arabam.android.assigment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.arabam.android.assigment.R
import com.arabam.android.assigment.databinding.AdListRowBinding
import com.arabam.android.assigment.model.ListModel
import com.arabam.android.assigment.view.ListFragmentDirections
import kotlinx.android.synthetic.main.ad_list_row.view.*

class ListRecyclerViewAdapter(val adList: ArrayList<ListModel>) : RecyclerView.Adapter<ListRecyclerViewAdapter.ListViewHolder>(), ListClickListener {
    class ListViewHolder(var view: AdListRowBinding) : RecyclerView.ViewHolder(view.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<AdListRowBinding>(inflater, R.layout.ad_list_row,parent,false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return adList.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.view.list = adList[position]
        holder.view.listener = this
    }

    fun adListUpdate(newAdList: List<ListModel>){
        adList.clear()
        adList.addAll(newAdList)
        notifyDataSetChanged()
    }

    override fun clicked(view: View){
        val id = view.getItemId.text.toString().toInt()
        val action = ListFragmentDirections.actionListFragmentToDetailFragment(id)
        Navigation.findNavController(view).navigate(action)
    }
}