package com.herry.nestednavigation.ext

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.core.view.children
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController

private fun findNavHostParentFragment(fragment: Fragment?): Fragment? {
    fragment ?: return null

    var parentFragment: Fragment? = fragment.parentFragment
    while (parentFragment != null) {
        if (parentFragment is NavHostFragment) {
            return parentFragment
        }

        parentFragment = parentFragment.parentFragment
    }

    return null
}

private fun hasNavHostFragment(view: View?, fragmentManager: FragmentManager): Boolean {
    view ?: return false

    if (view is ViewGroup) {
        view.children.forEach {
            if (hasNavHostFragment(it, fragmentManager)) {
                return true
            }
        }
    }

    if (view is NavHostFragment) {
        return true
    }

    if (view is FragmentContainerView) {
        return fragmentManager.fragments.isNotEmpty()
    }

    return false
}

private fun hasNavHostFragment(fragment: Fragment?): Boolean {
    fragment ?: return false

    return hasNavHostFragment(fragment.view, fragment.childFragmentManager)
}

fun Fragment.setNavNestedFragmentResultListener(requestKey: String, listener: ((requestKey: String, bundle: Bundle) -> Unit)) {
    val fragmentManager = if (hasNavHostFragment(this)) childFragmentManager else return
    fragmentManager.setFragmentResultListener(requestKey, this, listener)
}

fun Fragment.setNavNestedFragmentResult(requestKey: String, result: Bundle) {
    val fragmentManager = findNavHostParentFragment(this)?.parentFragment?.childFragmentManager ?: return
    fragmentManager.setFragmentResult(requestKey, result)
}

fun Fragment.getNavGraphID(): Int = findNavController().graph.id

fun Fragment.getNavCurrentDestinationID(): Int = findNavController().currentDestination?.id ?: 0