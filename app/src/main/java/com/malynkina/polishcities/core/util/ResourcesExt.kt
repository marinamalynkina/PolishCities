package com.malynkina.polishcities.core.util

import android.content.Context
import androidx.core.content.ContextCompat

fun Context.getColorByName(name: String): Int {
	return ContextCompat.getColor(
		this,
		resources.getIdentifier(name.toLowerCase(), "color", packageName)
	)
}