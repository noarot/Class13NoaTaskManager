package com.example.user.class13noataskmanager.data;

import java.util.HashMap;

/**
 * Created by user on 12/07/2017.
 */

public class MyUser {

    private String name;
    private String uKey_email; //primary key
    private String phone;
    private HashMap<String, Object> groupsKeys;
    private HashMap<String, Object> tasksKeys;

    public MyUser() {
        groupsKeys = new HashMap<>();
        tasksKeys = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getuKey_email() {
        //a key can't contain: '.', '#', '$', '[', ']'. need to replace the '.' with a different symbol
        return uKey_email.replace('.','*');
    }

    public void setuKey_email(String uKey_email) {
        this.uKey_email = uKey_email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public HashMap<String, Object> getGroupsKeys() {
        return groupsKeys;
    }

    public void setGroupsKeys(HashMap<String, Object> groupKeys) {
        this.groupsKeys = groupKeys;
    }

    public HashMap<String, Object> getTasksKeys() {
        return tasksKeys;
    }

    public void setTasksKeys(HashMap<String, Object> tasksKeys) {
        this.tasksKeys = tasksKeys;
    }

    public void addGroupKey(String groupKey)
    {
        this.groupsKeys.put(groupKey, true);
    }

    public void addtaskKey(String taskKey)
    {
        this.tasksKeys.put(taskKey, true);
    }

    @Override
    public String toString() {
        return "MyUser{" +
                "name='" + name + '\'' +
                ", uKey_email='" + uKey_email + '\'' +
                ", phone='" + phone + '\'' +
                ", groupsKeys=" + groupsKeys +
                ", tasksKeys=" + tasksKeys +
                '}';
    }
}
