package com.example.androidprojectgroup_26.Objects;

public class Ratting {
    String ID, Message, UserName, UserEmail, FoodCenterID, Date;
    int Stars;


    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserEmail() {
        return UserEmail;
    }

    public void setUserEmail(String userEmail) {
        UserEmail = userEmail;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getFoodCenterID() {
        return FoodCenterID;
    }

    public void setFoodCenterID(String foodCenterID) {
        FoodCenterID = foodCenterID;
    }

    public int getStars() {
        return Stars;
    }

    public void setStars(int stars) {
        Stars = stars;
    }
}
