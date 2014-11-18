package ua.ck.geekhub.android.dubiy.ufo.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;

import ua.ck.geekhub.android.dubiy.ufo.R;

public class FragmentWeb extends Fragment {
    private final String LOG_TAG = this.getClass().getSimpleName();
    private WebView webView;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstaceState) {
        Log.d(LOG_TAG, "fragmentAnim onCreateView");
        View v = inflater.inflate(R.layout.web_layout, null);
        webView = (WebView)v.findViewById(R.id.web_view);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("http://bash.im");

        return v;
    }






}
