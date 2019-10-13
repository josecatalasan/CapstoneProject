package com.example.androidcapstone.view.fragments


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.androidcapstone.R
import kotlinx.android.synthetic.main.fragment_web_view.*
import android.webkit.WebView
import android.webkit.WebViewClient
import android.net.Uri
import com.facebook.share.model.ShareLinkContent


private const val url_tag = "url"

class WebViewFragment : Fragment() {

    private var url: String? = null

    companion object {
        @JvmStatic
        fun newInstance(url: String) =
            WebViewFragment().apply {
                arguments = Bundle().apply {
                    putString(url_tag, url)
                }
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            url = it.getString(url_tag)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_web_view, container, false)
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupWebView()
        setupShareButtons()

        super.onViewCreated(view, savedInstanceState)
    }

    private fun setupWebView(){
        webView.webViewClient = MyBrowser()
        webView.settings.loadsImagesAutomatically = true
        webView.settings.javaScriptEnabled = true
        webView.scrollBarStyle = View.SCROLLBARS_INSIDE_OVERLAY
        webView.loadUrl(url)
        webView.setOnKeyListener{_, key, event ->
            if(event.action == KeyEvent.ACTION_DOWN){
                when(key){
                    KeyEvent.KEYCODE_BACK ->{
                        if(webView.canGoBack()){
                            webView.goBack()
                            return@setOnKeyListener true
                        }
                    }
                }
            }
            false
        }
    }

    private fun setupShareButtons(){
        btnShare.setOnClickListener{
            val share = Intent.createChooser(Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, webView.url)
                type = "text/plain"
            }, null)
            startActivity(share)
        }

        btnShareTwitter.setOnClickListener{
            val tweet = Intent(Intent.ACTION_VIEW)
            tweet.data = Uri.parse("http://twitter.com/?status=" + Uri.encode(webView.url))
            startActivity(tweet)
        }

        val content = ShareLinkContent.Builder()
            .setContentUrl(Uri.parse(webView.url))
            .build()

        btnShareFacebook.shareContent = content

    }

    private inner class MyBrowser : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            view.loadUrl(url)
            return true
        }
    }
}
