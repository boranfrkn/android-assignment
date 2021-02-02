package com.arabam.android.assigment.util

import android.content.Context
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.arabam.android.assigment.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

fun ImageView.imageDownload(url: String, placeholder: CircularProgressDrawable){
    val options = RequestOptions().placeholder(placeholder).error(R.drawable.ic_baseline_directions_car_24)
    Glide.with(context)
        .setDefaultRequestOptions(options)
        .load(url.replace("{0}","800x600")).into(this)
}

fun createPlaceholer(context : Context) : CircularProgressDrawable{
    return CircularProgressDrawable(context).apply {
        strokeWidth = 8f
        centerRadius = 40f
        start()
    }
}