package ua.ck.geekhub.android.dubiy.ufo.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import ua.ck.geekhub.android.dubiy.ufo.R;

public class FragmentMP_list extends Fragment {
    OnLeftPaneSelectedListener mCallback;
    private String[] mListItems;
    private ListView mListView;

    public FragmentMP_list() {}

    // The container Activity must implement this interface so the frag can deliver messages
    public interface OnLeftPaneSelectedListener {
        public void onLeftPaneItemSelected(int position);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstaceState) {
        return inflater.inflate(R.layout.fragment_fragment_mp_list, container, false);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception.
        try {
            mCallback = (OnLeftPaneSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnLeftPaneSelectedListener");
        }
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mListItems = getResources().getStringArray(R.array.drawer_menu);
        mListView = (ListView)view.findViewById(R.id.listView);

        if (mListView != null) {
            mListView.setAdapter(new ArrayAdapter<String>(this.getActivity(), R.layout.drawer_list_item, mListItems));
            mListView.setOnItemClickListener(new ListView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView adapterView, View view, int position, long id) {
                    //Log.d("GARE", "ahaha");
                    mCallback.onLeftPaneItemSelected(position);

                    // Set the item as checked to be highlighted when in two-pane layout
//                    getListView().setItemChecked(position, true);

                }
            });




        }
//        mListView.setOnItemClickListener(new DrawerItemClickListener());

    }


}