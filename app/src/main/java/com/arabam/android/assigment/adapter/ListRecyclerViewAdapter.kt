package com.arabam.android.assigment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.arabam.android.assigment.R
import com.arabam.android.assigment.model.ListModel
import com.arabam.android.assigment.util.createPlaceholer
import com.arabam.android.assigment.util.imageDownload
import com.arabam.android.assigment.view.ListFragmentDirections
import kotlinx.android.synthetic.main.ad_list_row.view.*

class ListRecyclerViewAdapter(val adList: ArrayList<ListModel>) : RecyclerView.Adapter<ListRecyclerViewAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.ad_list_row,parent,false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return adList.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.itemView.title.text = adList.get(position).title
        holder.itemView.location.text = adList.get(position).location.cityName + "/" + adList.get(position).location.townName
        holder.itemView.price.text = adList.get(position).priceFormatted
        holder.itemView.imageBanner.imageDownload(adList.get(position).photo, createPlaceholer(holder.itemView.context))
        holder.itemView.setOnClickListener{
            val action = ListFragmentDirections.actionListFragmentToDetailFragment(adList.get(position).id)
            Navigation.findNavController(it).navigate(action)
        }
    }
    fun adListUpdate(newAdList: List<ListModel>){
        adList.clear()
        adList.addAll(newAdList)
        notifyDataSetChanged()
    }
}