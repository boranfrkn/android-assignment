package com.arabam.android.assigment.util

import android.content.Context
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.arabam.android.assigment.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import java.util.*

fun ImageView.imageDownload(url: String){
    val options = RequestOptions().error(R.drawable.ic_baseline_directions_car_24)
    Glide.with(context)
        .setDefaultRequestOptions(options)
        .load(url.replace("{0}","800x600"))
        .placeholder(createPlaceholer(context))
        .into(this)
}

fun createPlaceholer(context : Context) : CircularProgressDrawable{
    return CircularProgressDrawable(context).apply {
        strokeWidth = 8f
        centerRadius = 40f
        start()
    }
}

@BindingAdapter("android:downloadImage")
fun databindingImage(view : ImageView, url: String){
    view.imageDownload(url)
}

@BindingAdapter("android:imagesDownload")
fun detailImages(view : ImageView, list: List<String>){
    list.forEach {
        view.imageDownload(it)
    }
    //detail.photos dediğimde hata alıyorum.
}