package ua.ck.geekhub.android.dubiy.ufo;
import android.app.Activity;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Gary on 20.10.2014.
 */
public class Fragment1 extends Fragment {
    final String LOG_TAG = "myLogs";

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.d(LOG_TAG, "Fragment1 onAttach");
//        this.getActivity().toString();

    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LOG_TAG, "Fragment1 onCreate");
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstaceState) {
        Log.d(LOG_TAG, "fragment1 onCreateView");
        View v = inflater.inflate(R.layout.fragment1, null);
        Button button = (Button)v.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(LOG_TAG, "Button click in fragment 1");
                TextView tv = (TextView)getActivity().findViewById(R.id.textView);
                tv.setText("Access from fragment1");

                Fragment frag2 = getFragmentManager().findFragmentById(R.id.fragment2);
                Button btn2 = ((Button)frag2.getView().findViewById(R.id.button2));
                btn2.setText("access from fragment 1");
            }
        });
        return v;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(LOG_TAG, "fragment1 onActivityCreated");

    }

    public void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "fragment1 onStart");
    }

    public void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "fragment1 onResume");
//        TextView tv1 = (TextView) getView().findViewById(R.id.textView2);
//        tv1.setText(this.getActivity().toString());
//        tv1.setText("ololo");
    }

    public void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "fragment1 onPause");
    }

    public void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "fragment1 onStop");
    }

    public void onDestroyView() {
        super.onDestroyView();
        Log.d(LOG_TAG, "fragment1 onDestroyView");
    }

    public void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "fragment1 onDestroy");
    }

    public void onDetach() {
        super.onDetach();
        Log.d(LOG_TAG, "fragment1 onDetach");
    }







}
