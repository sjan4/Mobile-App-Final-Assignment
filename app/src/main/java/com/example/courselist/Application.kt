package com.example.courselist

import android.app.Activity
import android.os.Build
import android.os.Bundle
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

class Application: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.admission_webview)

        val site: WebView = findViewById(R.id.applicationView)

        site.loadUrl("https://ucc.edu.jm/apply/undergraduate")

        val webSettings = site.settings
        webSettings.javaScriptEnabled = true
    }
}
