package dev.pegasus.googledownloadablefonts.helper

import android.content.Context
import android.graphics.Typeface
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.TextView
import androidx.core.provider.FontRequest
import androidx.core.provider.FontsContractCompat
import dev.pegasus.googledownloadablefonts.R

class FontManager(private val context: Context) {

    companion object {
        const val TAG = "Magic"
    }

    fun applyFont(queryType: String, textView: TextView) {

        val request = FontRequest(
            "com.google.android.gms.fonts",
            "com.google.android.gms",
            queryType,
            R.array.com_google_android_gms_fonts_certs
        )

        val callback = object : FontsContractCompat.FontRequestCallback() {
            override fun onTypefaceRetrieved(typeface: Typeface?) {
                super.onTypefaceRetrieved(typeface)
                Log.d(TAG, "onTypefaceRetrieved: called")
                textView.typeface = typeface
            }

            override fun onTypefaceRequestFailed(reason: Int) {
                super.onTypefaceRequestFailed(reason)
                Log.d(TAG, "onTypefaceRequestFailed: called")
            }
        }
        FontsContractCompat.requestFont(context, request, callback, Handler(Looper.getMainLooper()))
    }
}