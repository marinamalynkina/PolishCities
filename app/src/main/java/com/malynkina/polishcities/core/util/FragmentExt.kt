package com.malynkina.polishcities.core.util

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import kotlin.reflect.KClass

@Suppress("UNCHECKED_CAST")
fun <T> Fragment.getArgument(key: String): T = arguments?.get(key) as T

@Suppress("UNCHECKED_CAST")
fun <T> Bundle.getArgument(key: String): T = get(key) as T

@Suppress("UNCHECKED_CAST")
fun <T> Fragment.findNestedFragment(type: Class<T>): T? =
	childFragmentManager.findFragmentByTag(type.simpleName) as? T

fun Fragment.addNestedFragment(@IdRes container: Int, fragment: Fragment) {
	childFragmentManager.beginTransaction()
		.replace(container, fragment, fragment::class.java.simpleName)
		.commit()
}

fun Fragment.addFragment(
	@IdRes container: Int,
	fragmentClass: KClass<out Fragment>,
	params: (Fragment.() -> Unit)? = null,
	actions: (Fragment.() -> Unit)? = null
): Fragment? {
	var createFragment = findNestedFragment(fragmentClass.java)?.apply {
		actions?.invoke(this)
	}
	if (createFragment == null) {
		createFragment = fragmentClass.java.newInstance()
			.apply {
				params?.invoke(this)
				actions?.invoke(this)
			}

		addNestedFragment(container,createFragment)
	}

	return createFragment
}