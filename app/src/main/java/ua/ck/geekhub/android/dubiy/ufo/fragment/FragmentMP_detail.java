package ua.ck.geekhub.android.dubiy.ufo.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import ua.ck.geekhub.android.dubiy.ufo.R;

public class FragmentMP_detail extends Fragment {
    public final static String ARG_LEFTPANEITEMPOSITION = "LeftPaneItemPosition";
    private WebView mWebView;
    private int mLeftPaneItemPosition = -1;
    private String[] mUrls;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstaceState) {
        if (savedInstaceState != null) {
            mLeftPaneItemPosition = savedInstaceState.getInt(ARG_LEFTPANEITEMPOSITION);
        }

        return inflater.inflate(R.layout.fragment_fragment_mp_detail, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mWebView = (WebView)view.findViewById(R.id.webView);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mUrls = getResources().getStringArray(R.array.urls);

//        Bundle args = getActivity().getIntent().getExtras();
//        if (args != null) {
//            // Set article based on argument passed in
//            LoadSomeContent(args.getInt(ARG_LEFTPANEITEMPOSITION));
//        } else if (mLeftPaneItemPosition != -1) {
//            // Set article based on saved instance state defined during onCreateView
//            LoadSomeContent(mLeftPaneItemPosition);
//        }
    }

    public FragmentMP_detail() {

    }

    @Override
    public void onStart() {
        super.onStart();

        // During startup, check if there are arguments passed to the fragment.
        // onStart is a good place to do this because the layout has already been
        // applied to the fragment at this point so we can safely call the method
        // below that sets the article text.
        Bundle args = getActivity().getIntent().getExtras();
        if (args != null) {
            int defValue = mLeftPaneItemPosition;
            if (defValue == -1) {
                defValue = 0;
            }

            // Set article based on argument passed in
            //TODO розібраться чому при перевороті екрану "args.getInt(ARG_LEFTPANEITEMPOSITION)" не отримає значення. і повертає дефолт
            LoadSomeContent(args.getInt(ARG_LEFTPANEITEMPOSITION, defValue));
        } else if (mLeftPaneItemPosition != -1) {
            // Set article based on saved instance state defined during onCreateView
            LoadSomeContent(mLeftPaneItemPosition);
        }
    }

    public void LoadSomeContent(int LeftPaneItemPosition) {
        //TODO розібратися чому цей метод викликається 2 рази. при другому виклику (mTextView == null). програмістика...



        if (mWebView != null) {
            mLeftPaneItemPosition = LeftPaneItemPosition;
//            getActivity().getIntent().getExtras().putInt(ARG_LEFTPANEITEMPOSITION, mLeftPaneItemPosition);
//            mWebView.setText("pkee" + mLeftPaneItemPosition);
            Toast.makeText(getActivity().getApplicationContext(), "oke " + mLeftPaneItemPosition, Toast.LENGTH_LONG).show();

//            mUrls = getResources().getStringArray(R.array.urls);
            //TODO зробити щоб при перевороті екрану не грузилася сторінка заново. якщо можливо
            WebSettings webSettings = mWebView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            mWebView.setWebViewClient(new WebViewClient());
            mWebView.loadUrl("http://" + mUrls[mLeftPaneItemPosition]);
        } else {
            Toast.makeText(getActivity().getApplicationContext(), "mWebView is null " + mLeftPaneItemPosition, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Save the current article selection in case we need to recreate the fragment
        outState.putInt(ARG_LEFTPANEITEMPOSITION, mLeftPaneItemPosition);
    }

}