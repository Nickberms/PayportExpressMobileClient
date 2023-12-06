package com.example.payportexpress;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private WebView webView;
    private EditText editTextUrl;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextUrl = findViewById(R.id.edtEnterLink);
        Button btnLoadUrl = findViewById(R.id.btnLoadLink);
        webView = findViewById(R.id.WebLayout);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        webView.loadUrl("http://136.172.221.198:8084/PayportExpressWebClient/");
        btnLoadUrl.setOnClickListener(v -> {
            String url = editTextUrl.getText().toString();
            if (!url.isEmpty()) {
                webView.loadUrl(url);
            }
        });
    }
}