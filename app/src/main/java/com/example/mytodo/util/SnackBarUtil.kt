package com.example.mytodo.util

import android.app.Activity
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

fun Fragment.showLongSnackBar(message: CharSequence) {
    Snackbar.make(this.requireView(), message, Snackbar.LENGTH_SHORT).show()
}

fun Activity.showLongSnackBar(message: CharSequence) {
    Snackbar.make(this.window.decorView, message, Snackbar.LENGTH_SHORT).show()
}


