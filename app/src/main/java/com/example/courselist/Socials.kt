package com.example.courselist

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class Socials: AppCompatActivity() {

    private lateinit var webView: WebView
    private lateinit var imageInstagram: ImageView
    private lateinit var imageFacebook: ImageView
    private lateinit var imageTwitter: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.socials_activity)

        webView = findViewById(R.id.webView)
        imageInstagram=findViewById(R.id.instagram)
        imageFacebook=findViewById(R.id.facebook)
        imageTwitter=findViewById(R.id.twitter)

        webView.webViewClient= WebViewClient()


        imageInstagram.setOnClickListener {
            webView.loadUrl("https://www.instagram.com/uccjamaica/")
        }

        imageFacebook.setOnClickListener {
            webView.loadUrl("https://www.facebook.com/uccjamaica/")
        }

        imageTwitter.setOnClickListener {
            webView.loadUrl("https://twitter.com/uccjamaica/")
        }

        webView.settings.javaScriptEnabled=true


    }
}
