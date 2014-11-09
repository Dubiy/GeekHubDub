package ua.ck.geekhub.android.dubiy.ufo.fragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.Serializable;

import ua.ck.geekhub.android.dubiy.ufo.R;
import ua.ck.geekhub.android.dubiy.ufo.entity.HabraPost;

public class FragmentJsonContent extends Fragment {
//    private OnFragmentInteractionListener mListener;
    public final static String ARG_LEFTPANEITEMPOSITION = "LeftPaneItemPosition";
    private HabraPost mHabraPost;
    private String jsonMyObject;
    private WebView mWebView;

    public FragmentJsonContent() {
        // Required empty public constructor
    }

    /*public static FragmentJsonContent newInstance(String param1, String param2) {
        FragmentJsonContent fragment = new FragmentJsonContent();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }*/

    @Override
    public void onStart() {
        super.onStart();
        Bundle args = getActivity().getIntent().getExtras();
        if (args != null) {
            jsonMyObject = args.getString("HABRAPOST");
            mHabraPost = new Gson().fromJson(jsonMyObject, HabraPost.class);
            LoadSomeContent(0, mHabraPost);
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            jsonMyObject = getArguments().getString("HABRAPOST");
            mHabraPost = new Gson().fromJson(jsonMyObject, HabraPost.class);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_json_content, container, false);
    }

    public void onViewCreated(final View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mWebView = (WebView)view.findViewById(R.id.webView);
        if (savedInstanceState != null) {
            jsonMyObject = savedInstanceState.getString("HABRAPOST");
            mHabraPost = new Gson().fromJson(jsonMyObject, HabraPost.class);
        }
        if (mHabraPost == null) {
            mHabraPost = new HabraPost();
        } else {
            LoadSomeContent(0, mHabraPost);
        }

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        /*try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnFragmentInteractionListener");
        }*/
    }

    @Override
    public void onDetach() {
        super.onDetach();
//        mListener = null;
    }

    //interface
    /*public interface OnFragmentInteractionListener {
        public void onFragmentInteraction(Uri uri);
    }*/

    public void LoadSomeContent(int LeftPaneItemPosition, HabraPost habraPost) {
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mWebView.loadData(habraPost.toString(), "text/html", "UTF-8");
        mWebView.loadDataWithBaseURL("", habraPost.Content, "text/html", "UTF-8", "");
    }

}