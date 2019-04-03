package com.example.androidprojectgroup_26.Session;

import android.app.Application;

public class MyApplication extends Application {

    String SelectedFoodCenterName, SelectedFoodCenterID;
    int SelectedFoodCenterImage;
    com.example.androidprojectgroup_26.Objects.User user = null;


    @Override
    public void onCreate() {
        super.onCreate();
    }

    public String getSelectedFoodCenterName() {
        return SelectedFoodCenterName;
    }

    public void setSelectedFoodCenterName(String selectedFoodCenterName) {
        SelectedFoodCenterName = selectedFoodCenterName;
    }

    public String getSelectedFoodCenterID() {
        return SelectedFoodCenterID;
    }

    public void setSelectedFoodCenterID(String selectedFoodCenterID) {
        SelectedFoodCenterID = selectedFoodCenterID;
    }

    public int getSelectedFoodCenterImage() {
        return SelectedFoodCenterImage;
    }

    public void setSelectedFoodCenterImage(int selectedFoodCenterImage) {
        SelectedFoodCenterImage = selectedFoodCenterImage;
    }

    public com.example.androidprojectgroup_26.Objects.User getUser() {
        return user;
    }

    public void setUser(com.example.androidprojectgroup_26.Objects.User user) {
        this.user = user;
    }
}
