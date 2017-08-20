package com.example.user.class13noataskmanager.main_fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.user.class13noataskmanager.MainActivity;
import com.example.user.class13noataskmanager.R;
import com.example.user.class13noataskmanager.data.DBUtils;
import com.example.user.class13noataskmanager.data.MyTask;
import com.example.user.class13noataskmanager.data.TasksAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyTasksFragment extends Fragment implements TitleAble{

    private ListView lstVTasks;
    private TasksAdapter tasksAdapter;

    public MyTasksFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_tasks, container, false);
        lstVTasks = (ListView)view.findViewById(R.id.lstVTasks);
        initListView();
        return view;
    }

    private void initListView() {
        if (tasksAdapter == null)
        {
            tasksAdapter = new TasksAdapter(getActivity(),R.layout.itm_task);
        }

        //DBUtils.myTaskRef.addListenerForSingleValueEvent(//single value means that the listener listens only
                //once to get the data. if the data is changed, there is no notification.
        DBUtils.myTaskRef.addValueEventListener(//will update the view every time the data is changed
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        tasksAdapter.clear();
                        for (DataSnapshot ds : dataSnapshot.getChildren())
                        {
                            MyTask myTask = ds.getValue(MyTask.class); //getValue casts the object to the parameter type
                            tasksAdapter.add(myTask);
                        }
                        lstVTasks.setAdapter(tasksAdapter);

                        //the same loop with for
//                        for (int i = 0; i < dataSnapshot.getChildrenCount(); i++) {
//                            DataSnapshot ds = dataSnapshot.getChildren().iterator().next();
//                            MyTask myTask = ds.getValue(MyTask.class);
//                            tasksAdapter.add(myTask);
//                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



    }

    public String getTitle()
    {
        return "My Tasks";
    }

}
