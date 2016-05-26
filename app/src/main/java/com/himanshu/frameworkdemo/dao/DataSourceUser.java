package com.himanshu.frameworkdemo.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.himanshu.frameworkdemo.helpers.DatabaseHelper;

/**
 * Database Manipulation Statements related to User table
 *
 * @author himanshup
 */
public class DataSourceUser {

    private static DataSourceUser dataSourceUser = null;

    private DatabaseHelper databaseHelper;

    private SQLiteDatabase sqLiteDatabase = null;

    private DataSourceUser(Context context) {
        databaseHelper = DatabaseHelper.getInstance(context);
    }

    public static synchronized DataSourceUser getInstance(Context context) {
        if (dataSourceUser == null) {
            dataSourceUser = new DataSourceUser(context);
        }
        return dataSourceUser;
    }

    public void open() {
        if (sqLiteDatabase == null) {
            sqLiteDatabase = databaseHelper.getWritableDatabase();
        } else {
            if (!sqLiteDatabase.isOpen()) {
                sqLiteDatabase = databaseHelper.getWritableDatabase();
            }
        }
    }

    public void close() {
        if (sqLiteDatabase != null) {
            if (sqLiteDatabase.isOpen()) {
                sqLiteDatabase.close();
            }
        }
    }

//    public boolean insert(User user) {
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(IDatabase.USER_ID, user.getId());
//        contentValues.put(IDatabase.FULL_NAME, user.getFullName());
//        contentValues.put(IDatabase.PERSON, user.getPerson());
//        contentValues.put(IDatabase.CITY, user.getCity());
//        contentValues.put(IDatabase.ROUTE, user.getRoute());
//        return sqLiteDatabase.insert(IDatabase.TABLE_USER, null, contentValues) > -1;
//    }
//
//    public void delete() {
//        sqLiteDatabase.delete(IDatabase.TABLE_USER, null, null);
//    }
//
//
//    public ArrayList<User> getRecords() {
//        ArrayList<User> arrayList = new ArrayList<>();
//        Cursor cursor = sqLiteDatabase.query(IDatabase.TABLE_USER, IDatabase.COLUMNS_USER, null, null, null, null, null);
//        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
//            User user = new User();
//            user.setId(cursor.getString(cursor.getColumnIndex(IDatabase.USER_ID)));
//            user.setFullName(cursor.getString(cursor.getColumnIndex(IDatabase.FULL_NAME)));
//            user.setPerson(cursor.getString(cursor.getColumnIndex(IDatabase.PERSON)));
//            user.setCity(cursor.getString(cursor.getColumnIndex(IDatabase.CITY)));
//            user.setRoute(cursor.getString(cursor.getColumnIndex(IDatabase.ROUTE)));
//            arrayList.add(user);
//        }
//        return arrayList;
//    }
//
//    public User getRecord(String id) {
//        User user = new User();
//        Cursor cursor = sqLiteDatabase.query(IDatabase.TABLE_USER, IDatabase.COLUMNS_USER, IDatabase.USER_ID + " = '" + id + "'", null, null, null, null);
////        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
//        if (cursor.moveToFirst()) {
//            user.setId(cursor.getString(cursor.getColumnIndex(IDatabase.USER_ID)));
//            user.setFullName(cursor.getString(cursor.getColumnIndex(IDatabase.FULL_NAME)));
//            user.setPerson(cursor.getString(cursor.getColumnIndex(IDatabase.PERSON)));
//            user.setCity(cursor.getString(cursor.getColumnIndex(IDatabase.CITY)));
//            user.setRoute(cursor.getString(cursor.getColumnIndex(IDatabase.ROUTE)));
//        }
//        return user;
//    }
}
