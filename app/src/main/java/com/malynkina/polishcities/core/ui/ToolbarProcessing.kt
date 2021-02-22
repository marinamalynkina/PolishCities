package com.malynkina.polishcities.core.ui

import androidx.fragment.app.Fragment

interface ToolbarProcessing {
    fun setToolbarTitleAndColor(title: String, color: String)
}

fun Fragment.setToolbarTitle(title: String, color: String) {
    (activity as? ToolbarProcessing)?.setToolbarTitleAndColor(title, color)
}