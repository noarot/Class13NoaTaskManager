package com.example.user.class13noataskmanager.data;

/**
 * Created by user on 12/07/2017.
 */

public class MyTask {
    private String tKey;
    private String text;
    private Boolean isCompleted;
    private long createdAt;
    private double loc_lat, loc_lng;
    private String address;
    private String gKey, uKey;

    public MyTask() {
    }

    public String gettKey() {
        return tKey;
    }

    public void settKey(String tKey) {
        this.tKey = tKey;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getCompleted() {
        return isCompleted;
    }

    public void setCompleted(Boolean completed) {
        isCompleted = completed;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public double getLoc_lat() {
        return loc_lat;
    }

    public void setLoc_lat(double loc_lat) {
        this.loc_lat = loc_lat;
    }

    public double getLoc_lng() {
        return loc_lng;
    }

    public void setLoc_lng(double loc_lng) {
        this.loc_lng = loc_lng;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getgKey() {
        return gKey;
    }

    public void setgKey(String gKey) {
        this.gKey = gKey;
    }

    public String getuKey() {
        return uKey;
    }

    public void setuKey(String uKey) {
        this.uKey = uKey;
    }

    @Override
    public String toString() {
        return "MyTask{" +
                "tKey='" + tKey + '\'' +
                ", text='" + text + '\'' +
                ", isCompleted=" + isCompleted +
                ", createdAt=" + createdAt +
                ", loc_lat=" + loc_lat +
                ", loc_lng=" + loc_lng +
                ", address='" + address + '\'' +
                ", gKey='" + gKey + '\'' +
                ", uKey='" + uKey + '\'' +
                '}';
    }
}
