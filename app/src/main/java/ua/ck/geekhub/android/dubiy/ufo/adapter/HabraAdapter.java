package ua.ck.geekhub.android.dubiy.ufo.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import ua.ck.geekhub.android.dubiy.ufo.R;
import ua.ck.geekhub.android.dubiy.ufo.entity.HabraPost;

/**
 * Created by Gary on 08.11.2014.
 */
public class HabraAdapter extends ArrayAdapter {
    Context mContext;
    int layoutResourceId;
    HabraPost data[] = null;

    public HabraAdapter(Context mContext, int layoutResourceId, HabraPost[] data) {
        super(mContext, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        /*
         * The convertView argument is essentially a "ScrapView" as described is Lucas post
         * http://lucasr.org/2012/04/05/performance-tips-for-androids-listview/
         * It will have a non-null value when ListView is asking you recycle the row layout.
         * So, when convertView is not null, you should simply update its contents instead of inflating a new row layout.
         */
        if (convertView == null) {
            //inflate layout
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            convertView = inflater.inflate(layoutResourceId, parent, false);
        }

        //object item based on the position
        HabraPost objectItem = data[position];

        TextView textViewTitle = (TextView)convertView.findViewById(R.id.textViewTitle);
        TextView textViewDate = (TextView)convertView.findViewById(R.id.textViewDate);

        textViewTitle.setText(objectItem.Title);
        textViewDate.setText(objectItem.PublishDate);

        return convertView;

    }

}
