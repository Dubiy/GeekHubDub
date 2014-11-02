package ua.ck.geekhub.android.dubiy.ufo.activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import ua.ck.geekhub.android.dubiy.ufo.fragment.Fragment1;
import ua.ck.geekhub.android.dubiy.ufo.fragment.Fragment2;
import ua.ck.geekhub.android.dubiy.ufo.R;
import ua.ck.geekhub.android.dubiy.ufo.fragment.FragmentWeb;

public class StartActivity extends Activity {

    private String[] mMenuItems;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        mTitle = mDrawerTitle = getTitle();
        mMenuItems = getResources().getStringArray(R.array.drawer_menu);
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        mDrawerList = (ListView)findViewById(R.id.left_drawer);

        mDrawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_item, mMenuItems));
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.drawable.ic_drawer, R.string.drawer_open, R.string.drawer_close) {
            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getActionBar().setTitle(mTitle);
                invalidateOptionsMenu();
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getActionBar().setTitle(mDrawerTitle);
                invalidateOptionsMenu();
            }

            // Set the drawer toggle as the DrawerListener

        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        if (savedInstanceState == null) {
            selectItem(0, 0);
        }
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView parent, View view, int position, long id) {
//            Log.d("GARE", "ahaha");
            selectItem(position, id);
//            Toast.makeText(getApplicationContext(), "LeftDrawer item clicked. Pos: " + position + ". ID: " + id + ". Item:" + mMenuItems[position], Toast.LENGTH_LONG).show();
        }
    }

    private void selectItem(int position, long id) {
        FragmentTransaction fTrans = getFragmentManager().beginTransaction();

        Fragment fragment = new Fragment();
        switch (position) {
            case 0: {
                Fragment1 fragment1 = new Fragment1();
                fTrans.replace(R.id.content_frame, fragment1);
            } break;
            case 1: {
                Fragment2 fragment2 = new Fragment2();
                fTrans.replace(R.id.content_frame, fragment2);
            } break;
            case 2: {
                FragmentWeb fragmentWeb = new FragmentWeb();
                fTrans.replace(R.id.content_frame, fragmentWeb);
            } break;
            case 3: {
                Intent intent = new Intent(this, Activity_multipane.class);
                intent.putExtra("testValue", "zoldberg");
                startActivity(intent);
            } break;
            default: {
                Toast.makeText(getApplicationContext(), "Unknown item", Toast.LENGTH_LONG).show();
            }
        }

        setTitle(mMenuItems[position]);

        fTrans.addToBackStack(null);
        fTrans.commit();


        mDrawerList.setItemChecked(position, true);
        mDrawerLayout.closeDrawer(mDrawerList);
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getActionBar().setTitle(mTitle);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.start, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /* Called whenever we call invalidateOptionsMenu() */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // If the nav drawer is open, hide action items related to the content view
        boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
        menu.findItem(R.id.action_websearch).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        int id = item.getItemId();
        switch (id) {
            case R.id.action_settings: {
                Toast.makeText(getApplicationContext(), "Settings item. do smth", Toast.LENGTH_LONG).show();
            } break;
            case R.id.action_about: {
                Toast.makeText(getApplicationContext(), "Створив Ігор Дубій\nSpecially 4 GeekHub", Toast.LENGTH_LONG).show();
            } break;
            case R.id.action_websearch: {
                // create intent to perform web search for this planet
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY, getActionBar().getTitle());
                // catch event that there's no activity to handle intent
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "App not available", Toast.LENGTH_SHORT).show();
                }
            } break;

            default: {
                Toast.makeText(getApplicationContext(), "Unknown menu item: " + item.getTitle(), Toast.LENGTH_LONG).show();
                return super.onOptionsItemSelected(item);
            }
        }
        return true;
    }
}
