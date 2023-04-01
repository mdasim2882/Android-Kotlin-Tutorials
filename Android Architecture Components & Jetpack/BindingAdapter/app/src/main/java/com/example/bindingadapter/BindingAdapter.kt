package com.example.bindingadapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso

@BindingAdapter("imageFromUrl")
fun ImageView.imageFromUrl(url: String) {
//    Picasso.get().load(url).into(this)
    Glide.with(this.context)
        .load(url)
        .override(400,400)
        .into(this)

}
