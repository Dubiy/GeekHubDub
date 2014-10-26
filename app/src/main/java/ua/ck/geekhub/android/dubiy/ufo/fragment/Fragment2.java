package ua.ck.geekhub.android.dubiy.ufo.fragment;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

import ua.ck.geekhub.android.dubiy.ufo.R;

/**
 * Created by Gary on 20.10.2014.
 */
public class Fragment2 extends Fragment {
    final String LOG_TAG = "myLogs";

    char[] chars;
    Random random = new Random();
    ListView listView;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.d(LOG_TAG, "Fragment2 onAttach");
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LOG_TAG, "Fragment2 onCreate");

        StringBuilder tmp = new StringBuilder();
        for (char c = '0'; c <= '9'; c++) {
            tmp.append(c);
        }
        for (char c = 'a'; c <= 'z'; c++) {
            tmp.append(c);
        }
        chars = tmp.toString().toCharArray();

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment2, null);
        listView = (ListView)v.findViewById(R.id.listView);

        Button btn_gen_list = (Button) v.findViewById(R.id.btn_gen_list);
        btn_gen_list.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int list_length = 20 + random.nextInt(10);
                char[] tmp;
                String[] listItems = new String[list_length];
                for (int i = 0; i < list_length; i++) {
                    int item_length = 10 + random.nextInt(10);
                    tmp = new char[item_length];
                    for (int j = 0; j < item_length; j++) {
                        tmp[j] = chars[random.nextInt(chars.length)];
                    }
                    tmp[0] = Character.toUpperCase(tmp[0]);
                    listItems[i] = new String(tmp);
                }

                ArrayAdapter adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1, listItems);
                listView.setAdapter(adapter);
                listView.setOnItemClickListener(new ListItemClickListener());
            }
        });

        return v;
    }

    private class ListItemClickListener implements ListView.OnItemClickListener {
        public ListItemClickListener() {

        }

        @Override
        public void onItemClick(AdapterView adapterView, View view, int i, long l) {
            Toast.makeText(getActivity().getApplicationContext(), "Clicked \"" + listView.getItemAtPosition(i).toString() + "\" item", Toast.LENGTH_LONG).show();
        }
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(LOG_TAG, "fragment2 onActivityCreated");
    }

    public void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "fragment2 onStart");
    }

    public void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "fragment2 onResume");
    }

    public void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "fragment2 onPause");
    }

    public void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "fragment2 onStop");
    }

    public void onDestroyView() {
        super.onDestroyView();
        Log.d(LOG_TAG, "fragment2 onDestroyView");
    }

    public void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "fragment2 onDestroy");
    }

    public void onDetach() {
        super.onDetach();
        Log.d(LOG_TAG, "fragment2 onDetach");
    }







}
