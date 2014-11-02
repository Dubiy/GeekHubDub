package ua.ck.geekhub.android.dubiy.ufo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.Random;

import ua.ck.geekhub.android.dubiy.ufo.R;
import ua.ck.geekhub.android.dubiy.ufo.fragment.FragmentMP_detail;
import ua.ck.geekhub.android.dubiy.ufo.fragment.FragmentMP_list;

public class Activity_multipane extends Activity implements FragmentMP_list.OnLeftPaneSelectedListener {

/*
    public void onItemSelectedListener(int position) {
        Log.d("GARE", "OnItemSelectedListener  fragment");
        Toast.makeText(getApplicationContext(), "OnItemSelectedListener  fragment", Toast.LENGTH_LONG).show();
    }
*/












    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multipane);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_multipane, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onLeftPaneItemSelected(int position) {
        //FragmentMP_list intefrace

//        Random random = new Random();
//        Toast.makeText(this, "[activity!!!] item clicked.  Pos: " + position + ". Random: " + random.nextInt(), Toast.LENGTH_LONG).show();

        FragmentMP_detail fragmentMP_detail = (FragmentMP_detail)getFragmentManager().findFragmentById(R.id.fragment_mp_detail);
        if (fragmentMP_detail == null) {
//            //ActivityB here
//            /*Intent intent = new Intent(this, FragmentMP_detail.class);
//            intent.putExtra("LeftPaneItemPosition", position);
//            startActivity(intent);*/
        } else {
            fragmentMP_detail.LoaddContent(position);
            Toast.makeText(this, "mTextView is null", Toast.LENGTH_LONG).show();
        }




    }
}
