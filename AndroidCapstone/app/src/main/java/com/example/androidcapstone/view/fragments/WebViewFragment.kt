package com.example.androidcapstone.view.fragments


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

private const val url = "url"

class WebViewFragment : Fragment() {

    private var url: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            url = it.getString(com.example.androidcapstone.view.fragments.url)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_web_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
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

        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        @JvmStatic
        fun newInstance(url: String) =
            WebViewFragment().apply {
                arguments = Bundle().apply {
                    putString(com.example.androidcapstone.view.fragments.url, url)
                }
            }
    }

    private inner class MyBrowser : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            view.loadUrl(url)
            return true
        }
    }
}
