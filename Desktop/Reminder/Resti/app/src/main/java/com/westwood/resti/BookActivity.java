package com.westwood.resti;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Westwood on 9/25/16.
 */
public class BookActivity extends RoutesActivity{

    String urls = "https://www.delta.com/cart/activity/passengerinfo.action";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        WebView webView = (WebView) findViewById(R.id.wvBook);

        assert webView != null;
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        webView.loadUrl(urls);
    }
}
