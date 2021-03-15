package com.example.menagevehiclefragment.`object`

import android.content.Context
import android.graphics.drawable.Drawable
import android.net.Uri
import androidx.core.content.ContextCompat
import com.example.menagevehiclefragment.R

object UriToDrawableConverter {
    fun uriToDrawable(uri: String?, context: Context): Drawable?{
        uri?.let {
            val inputStream = context.contentResolver.openInputStream(Uri.parse(uri))
            return Drawable.createFromStream(inputStream, uri)
        }
        return ContextCompat.getDrawable(context, R.drawable.default_car)
    }
}