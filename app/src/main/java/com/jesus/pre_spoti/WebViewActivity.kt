package com.jesus.pre_spoti

import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_web_view.*

class WebViewActivity : AppCompatActivity() {

    private val BASE_URL = "https://www.spotify.com/es/purchase/offer/holiday-2020-trial-3m/"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        WebView.settings.javaScriptEnabled = true

        WebView.webChromeClient = WebChromeClient()
        WebView.webViewClient = WebViewClient()
        WebView.loadUrl(BASE_URL)
    }

    override fun onBackPressed() {
        if (WebView.canGoBack()) WebView.goBack() else super.onBackPressed()
    }
}