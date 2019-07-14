package com.codedevtech.alc4phase1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import java.util.Objects;

import android.net.http.*; //added this import statement



public class ActivityB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        //display back button
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        WebView webView = findViewById(R.id.webview);


        //enable js (might introduce xss vulnerabilities, gotta research on that one
        webView.getSettings().setJavaScriptEnabled(true);

        //set up a progress bar using chrome client
        webView.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                // Activities and WebViews measure progress
                // The progress meter will automatically disappear when we reach 100%, hopefully XD
                setProgress(progress * 1000);

                Log.d("progress",String.valueOf(progress));
            }

        });

        //handle errors, for instance the alc webpage goes offline, or no internet connection
        webView.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(getBaseContext(), R.string.error, Toast.LENGTH_LONG).show();
            }

            //took a while, but there was an ssl error which was preventing the handler from loading the webpage into the webview
            //pretty hard to find since it wasn't throwing any errors!
            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error){
                handler.proceed();
            }
        });

        webView.loadUrl("https://andela.com/alc/");



    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();

                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
