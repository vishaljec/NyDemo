package com.news.demo.utils

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.ConnectivityManager
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AlertDialog
import com.news.demo.R


object ActivityUtils {


    const val NETWORK_ERROR: String = "Network connection error: Check your internet connectivity";

    fun progressDialog(context: Context): AlertDialog {
        val builder = AlertDialog.Builder(context)
        builder.setView(R.layout.ny_progress)
        val dialog = builder.create()
        dialog.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setCancelable(false)
        return dialog
    }


    fun hideSoftKeyBoard(activity: Activity) {
        val inputMethodManager: InputMethodManager = activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0)
    }


    /**
     * Checks if Network is available.
     *
     * @param inContext activity context.
     */
    @Synchronized
    fun isNetworkAvailable(inContext: Context): Boolean {
        val connectMgr = inContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = connectMgr.activeNetworkInfo ?: return false
        return netInfo.isConnected
    }

}