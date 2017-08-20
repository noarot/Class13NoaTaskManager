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
 * Created by user on 17/08/2017.
 */

public class TasksAdapter extends ArrayAdapter<MyTask> {

    public TasksAdapter(Context context, int resource) {
        super(context, resource);
    }

    //need to override this function. this is the way the adapter knows how to fill the data
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
        {
            //use the R.layout from our project package
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.itm_task, parent, false);
        }
        MyTask task = getItem(position);

        TextView tvText = (TextView)convertView.findViewById(R.id.itmTvText);
        TextView tvCreatedAt = (TextView)convertView.findViewById(R.id.itmTvCreatedAt);
        TextView tvAddress = (TextView)convertView.findViewById(R.id.itmTvAddress);
        TextView tvUser = (TextView)convertView.findViewById(R.id.itmTvUser);
        CheckBox cbIsCompleted = (CheckBox)convertView.findViewById(R.id.itmCbIsCompleted);
        Button btnGroup = (Button)convertView.findViewById(R.id.itmBtnGroup);

        tvText.setText(task.getText());
        tvAddress.setText(task.getAddress());
        tvCreatedAt.setText((new Date(task.getCreatedAt())).toString());
        tvUser.setText(task.getuKey()); // TODO: 17/08/2017 convert key to real name
        cbIsCompleted.setChecked(task.getCompleted());
        btnGroup.setText(task.getgKey()); // TODO: 17/08/2017 convert key to real name

        return convertView;
    }
}
