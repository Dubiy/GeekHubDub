package ua.ck.geekhub.android.dubiy.ufo.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import ua.ck.geekhub.android.dubiy.ufo.R;
import ua.ck.geekhub.android.dubiy.ufo.entity.HabraPost;
import ua.ck.geekhub.android.dubiy.ufo.fragment.FragmentJsonContent;
import ua.ck.geekhub.android.dubiy.ufo.fragment.FragmentJsonList;

public class ActivityJSON extends Activity implements FragmentJsonList.OnFragmentInteractionListener, FragmentJsonContent.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_json, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onLeftPaneItemSelected(Integer position, HabraPost habraPost) {
        Log.d("GARY", position.toString() + " " + habraPost.toString());

        FragmentJsonContent fragmentJsonContent = (FragmentJsonContent)getFragmentManager().findFragmentById(R.id.fragment_content)

        if (fragmentJsonContent == null) {
//            //ActivityB here
            Intent intent = new Intent(this, ActivityMultipaneRight.class);
            intent.putExtra(fragmentJsonContent.ARG_LEFTPANEITEMPOSITION, position);
            startActivity(intent);
        } else {
            fragmentJsonContent.LoadSomeContent(position);
            Toast.makeText(this, "mTextView is null", Toast.LENGTH_LONG).show();
        }
    }
}
