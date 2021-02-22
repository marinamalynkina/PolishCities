package com.malynkina.polishcities

import android.os.Bundle
import androidx.navigation.NavController

class Navigator(
	private var navController: NavController? = null
) {

	fun bind(navController: NavController) {
		this.navController = navController
	}

	fun unbind() {
		navController = null
	}

	fun navigate(actionId: Int, bundle: Bundle? = null) {
		navController?.navigate(actionId, bundle)
	}
}