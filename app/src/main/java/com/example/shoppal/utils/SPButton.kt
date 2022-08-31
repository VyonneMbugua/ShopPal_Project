package com.example.shoppal.utils

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText

class SPButton(context: Context, attrs: AttributeSet): AppCompatButton(context,attrs) {
    init {
        applyFont()
    }
    private fun applyFont(){
        val typeface: Typeface =
            Typeface.createFromAsset(context.assets,"Champhin.otf")
        setTypeface(typeface)
    }
}