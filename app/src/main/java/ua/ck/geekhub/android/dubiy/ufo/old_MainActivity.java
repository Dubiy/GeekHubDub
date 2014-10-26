package ua.ck.geekhub.android.dubiy.ufo;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.app.FragmentTransaction;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import ua.ck.geekhub.android.dubiy.ufo.fragment.Fragment1;
import ua.ck.geekhub.android.dubiy.ufo.fragment.Fragment2;


public class old_MainActivity extends Activity {

    Fragment1 fragment1;
    Fragment2 fragment2;
    FragmentTransaction fTrans;
    WebView webview;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        webview = (WebView)findViewById(R.id.web_view);

       /* fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(R.id.fragment2, fragment2);
        ft.commit();*/
    }

    public void onClick(View v) {
        fTrans = getFragmentManager().beginTransaction();
        switch (v.getId()) {
            case R.id.btn_wierd:
//                fTrans.add(R.id.)
                break;
            /*case R.id.btnAdd:
                fTrans.add(R.id.frgmCont, fragment1);
                fTrans.add(R.id.frgmCont, fragment2);
                break;
            case R.id.btnRemove:
                fTrans.remove(fragment1);
                break;
            case R.id.btnReplace:
                fTrans.replace(R.id.frgmCont, fragment2);*/
            default:
                break;
        }
        fTrans.addToBackStack(null);
        fTrans.commit();
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id) {
            case R.id.action_about:
                Toast.makeText(getApplicationContext(), "Створив Ігор Дубій\nSpecially 4 GeekHub", Toast.LENGTH_LONG).show();
            break;
            case R.id.action_load:

                WebSettings webSettings = webview.getSettings();
                webSettings.setJavaScriptEnabled(true);
                webview.setWebViewClient(new WebViewClient());
                webview.loadUrl("http://bash.im");
            break;
            default:
                Toast.makeText(getApplicationContext(), "Unknown menu item: " + item.getTitle(), Toast.LENGTH_LONG).show();
                break;
        }



        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && webview.canGoBack()) {
            webview.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}
