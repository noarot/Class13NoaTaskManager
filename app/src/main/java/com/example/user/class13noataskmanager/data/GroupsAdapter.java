package com.example.user.class13noataskmanager.data;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.user.class13noataskmanager.R;

import java.util.Date;

/**
 * Created by user on 20/08/2017.
 */

public class GroupsAdapter extends ArrayAdapter<MyGroup>{

    public GroupsAdapter(Context context, int resource) {
        super(context, resource);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
        {
            //use the R.layout from our project package
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.itm_group, parent, false);
        }
        MyGroup group = getItem(position);

        TextView tvGroupName = (TextView)convertView.findViewById(R.id.itmTvGroupName);
        TextView tvGroupOwner = (TextView)convertView.findViewById(R.id.itmTvGroupOwner);

        tvGroupName.setText(group.getName());
        tvGroupOwner.setText(group.getMngrUKey()); // TODO: 17/08/2017 convert key to real name

        return convertView;
    }
}
