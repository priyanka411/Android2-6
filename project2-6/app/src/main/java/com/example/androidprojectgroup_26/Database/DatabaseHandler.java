package com.example.androidprojectgroup_26.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.androidprojectgroup_26.Objects.Ratting;
import com.example.androidprojectgroup_26.Objects.user;

import java.util.ArrayList;
import java.util.List;


public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "WhatsGoodHere";
    private static final String TABLE_LOGIN = "LOGIN";
    private static final String KEY_ID = "id";
    private static final String NAME = "NAME";
    private static final String EMAIL = "EMAIL";
    private static final String PASSWORD = "PASSWORD";


    private static final String TABLE_RATTING = "RATTING";
    private static final String KEY_ID_RATTING = "id";
    private static final String NAME_USER = "NAME";
    private static final String EMAIL_USER = "EMAIL";

    private static final String MESSAGE = "MESSAGE";
    private static final String FOODCENTERID = "FOODCENTERID";
    private static final String DATE = "DATE";
    private static final String STARTS = "STARTS";


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //3rd argument to be passed is CursorFactory instance
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_userS_TABLE = "CREATE TABLE " + TABLE_LOGIN + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + NAME + " TEXT," + PASSWORD + " TEXT,"
                + EMAIL + " TEXT" + ")";
        db.execSQL(CREATE_userS_TABLE);


        String CREATE_RATTING_TABLE = "CREATE TABLE " + TABLE_RATTING + "("
                + KEY_ID_RATTING + " INTEGER PRIMARY KEY," + NAME_USER + " TEXT," + EMAIL_USER + " TEXT,"
                + MESSAGE + " TEXT,"
                + FOODCENTERID + " TEXT,"
                + DATE + " TEXT,"
                + STARTS + " TEXT" + ")";
        db.execSQL(CREATE_RATTING_TABLE);


    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOGIN);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RATTING);

        // Create tables again
        onCreate(db);
    }


    // code to get the single user
    user getuser(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_LOGIN, new String[]{KEY_ID,
                        NAME, EMAIL, PASSWORD}, KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        user user = new user();
        user.setID(cursor.getString(0));
        user.setName(cursor.getString(1));
        user.setEmail(cursor.getString(2));
        user.setPassword(cursor.getString(3));

        // return user
        return user;
    }


    // code to add the new user
    public void addUser(user user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME, user.getName());
        values.put(EMAIL, user.getEmail());
        values.put(PASSWORD, user.getPassword());

        // Inserting Row
        db.insert(TABLE_LOGIN, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }


    // code to get all users in a list view
    public List<user> getAllusers() {
        List<user> userList = new ArrayList<user>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_LOGIN;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                user user = new user();
                user.setID(cursor.getString(0));
                user.setName(cursor.getString(1));
                user.setPassword(cursor.getString(2));
                user.setEmail(cursor.getString(3));
                // Adding user to list
                userList.add(user);
            } while (cursor.moveToNext());
        }

        // return user list
        return userList;
    }


    // code to add the new ratting
    public void addRatting(Ratting ratting) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NAME_USER, ratting.getUserName());
        values.put(EMAIL_USER, ratting.getUserEmail());
        values.put(MESSAGE, ratting.getMessage());
        values.put(FOODCENTERID, ratting.getFoodCenterID());
        values.put(DATE, ratting.getDate());
        values.put(STARTS, ratting.getStars() + "");

        // Inserting Row
        db.insert(TABLE_RATTING, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }


    // code to get all rattings in a list view
    public List<Ratting> getAllrattings(int ID) {
        List<Ratting> RattingList = new ArrayList<Ratting>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_RATTING;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {

                Ratting ratting = new Ratting();
                ratting.setID(cursor.getString(0));
                ratting.setUserName(cursor.getString(1));
                ratting.setUserEmail(cursor.getString(2));
                ratting.setMessage(cursor.getString(3));
                ratting.setFoodCenterID(cursor.getString(4));
                ratting.setDate(cursor.getString(5));
                ratting.setStars(Integer.parseInt(cursor.getString(6)));

                // Adding ratting to list
                if (ratting.getFoodCenterID().equals(ID + ""))
                    RattingList.add(ratting);
            } while (cursor.moveToNext());
        }

        // return user list
        return RattingList;
    }


}