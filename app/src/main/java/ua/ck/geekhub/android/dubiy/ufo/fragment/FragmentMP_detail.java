package ua.ck.geekhub.android.dubiy.ufo.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import ua.ck.geekhub.android.dubiy.ufo.R;

public class FragmentMP_detail extends Fragment {

    private TextView mTextView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstaceState) {
        return inflater.inflate(R.layout.fragment_fragment_mp_detail, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTextView = (TextView)view.findViewById(R.id.textView);
    }

    public FragmentMP_detail() {

    }

    public void LoaddContent(int LeftPaneItemPosition) {
        if (mTextView != null) {
//            mTextView.setText(LeftPaneItemPosition);
            Toast.makeText(getActivity().getApplicationContext(), "oke " + LeftPaneItemPosition, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getActivity().getApplicationContext(), "mTextView is null " + LeftPaneItemPosition, Toast.LENGTH_LONG).show();
        }
    }
}