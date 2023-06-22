package com.example.hafiz_lms;


import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Android.db";
    private static final String TABLE_NAME = "Students";
    private static final String TABLE_NAME2 = "StudentDetails";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_AGE = "age";
    private static final String COLUMN_CLASS = "class";

    private static final String COLUMN_ROLL = "roll";

    private static final String COLUMN_SURAH = "surah";

    private static final String COLUMN_MANZIL = "manzil";

    private static final String COLUMN_SABQI = "sabqi";

    private static final String COLUMN_AYATSTART = "ayatStart";

    private static final String COLUMN_AYATEND = "ayatEnd";




    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "("
                + COLUMN_NAME + " TEXT,"
                + COLUMN_ROLL + " INTEGER,"
                + COLUMN_CLASS + " INTEGER,"
                + COLUMN_AGE + " INTEGER"
                + ")";
        db.execSQL(sql);


        String sql2 = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME2 + "("
                + COLUMN_ROLL + " INTEGER,"
                + COLUMN_SURAH + " TEXT,"
                + COLUMN_SABQI + " INTEGER,"
                + COLUMN_AYATSTART + " INTEGER,"
                + COLUMN_AYATEND + " INTEGER,"
                + COLUMN_MANZIL + " INTEGER"
                + ")";
        db.execSQL(sql2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(sql);
        String sql2 = "DROP TABLE IF EXISTS " + TABLE_NAME2;
        db.execSQL(sql2);
        onCreate(db);
    }


    public void editDetails(Details det){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ROLL, det.getRoll());
        values.put(COLUMN_SURAH, det.getSurah());
        values.put(COLUMN_MANZIL, det.getManzil());
        values.put(COLUMN_SABQI, det.getSabqi());
        values.put(COLUMN_AYATSTART, det.getAyatStart());
        values.put(COLUMN_AYATEND, det.getAyatEnd());

        db.update(TABLE_NAME2, values, COLUMN_ROLL + " = ?", new String[] {String.valueOf(det.getRoll())});
        db.close();

    }

    public void insertStudent(Students student) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, student.getName());
        values.put(COLUMN_AGE, student.getAge());
        values.put(COLUMN_CLASS, student.getClas());
        values.put(COLUMN_ROLL, student.getRoll());


        db.insert(TABLE_NAME, null, values);


        String sql2 = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME2 + "("
                + COLUMN_ROLL + " INTEGER,"
                + COLUMN_SURAH + " TEXT,"
                + COLUMN_SABQI + " INTEGER,"
                + COLUMN_AYATSTART + " INTEGER,"
                + COLUMN_AYATEND + " INTEGER,"
                + COLUMN_MANZIL + " INTEGER"
                + ")";
        db.execSQL(sql2);

        ContentValues values2 = new ContentValues();
        values2.put(COLUMN_ROLL, student.getRoll());
        values2.put(COLUMN_SURAH, "");
        values2.put(COLUMN_MANZIL, 1);
        values2.put(COLUMN_SABQI, 1);
        values2.put(COLUMN_AYATSTART, 0);
        values2.put(COLUMN_AYATEND, 1);

        db.insert(TABLE_NAME2, null, values2);



        db.close();
    }

    public void updateStudent(Students student) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, student.getName());
        values.put(COLUMN_AGE, student.getAge());
        values.put(COLUMN_CLASS, student.getClas());
        values.put(COLUMN_ROLL, student.getRoll());

        db.update(TABLE_NAME, values, COLUMN_ROLL + " = ?", new String[] {String.valueOf(student.getRoll())});
        db.close();
    }

    public void deleteStudent(String rollNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, COLUMN_ROLL + " = ?", new String[] {rollNo});
        db.close();
    }


    public List<Students> selectAllStudents() {
        List<Students> students = new ArrayList<>();

        String sql = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        /*
        * if (cursorCourses.moveToFirst()) {
            do {

                studentArrayList.add(new StudentModel(cursorCourses.getString(1),
                      cursorCourses.getInt(2),
                        cursorCourses.getInt(3) == 1 ? true : false));
            } while (cursorCourses.moveToNext());

        }
        * */

        if (cursor.moveToFirst()) {
            do {

                @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
                @SuppressLint("Range")  int rollNo = cursor.getInt(cursor.getColumnIndex(COLUMN_ROLL));
                @SuppressLint("Range")  int clas = cursor.getInt(cursor.getColumnIndex(COLUMN_CLASS));
                @SuppressLint("Range")  int age = cursor.getInt(cursor.getColumnIndex(COLUMN_AGE));
                students.add(new Students(name, age, clas, rollNo));

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return students;
    }



    public Details getDetails(int roll) {

        String sql = "SELECT * FROM " + TABLE_NAME2;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        /*
        * if (cursorCourses.moveToFirst()) {
            do {

                studentArrayList.add(new StudentModel(cursorCourses.getString(1),
                      cursorCourses.getInt(2),
                        cursorCourses.getInt(3) == 1 ? true : false));
            } while (cursorCourses.moveToNext());

        }
        * */
        Details studentdet = null;
        if(cursor == null){
            Log.d("cursor checker", "cursor is null");
        }
        else{
            Log.d("cursor checker", "cursor is not null");
        }
        if (cursor.moveToFirst()) {
            do {


                @SuppressLint("Range")  int rollNo = cursor.getInt(cursor.getColumnIndex(COLUMN_ROLL));
                @SuppressLint("Range")  String surah = cursor.getString(cursor.getColumnIndex(COLUMN_SURAH));
                @SuppressLint("Range")  int sabqi = cursor.getInt(cursor.getColumnIndex(COLUMN_SABQI));
                @SuppressLint("Range")  int manzil = cursor.getInt(cursor.getColumnIndex(COLUMN_MANZIL));
                @SuppressLint("Range")  int ayatend = cursor.getInt(cursor.getColumnIndex(COLUMN_AYATEND));
                @SuppressLint("Range")  int ayatstart = cursor.getInt(cursor.getColumnIndex(COLUMN_AYATSTART));
                if(roll == rollNo) {
                    studentdet = new Details(rollNo, surah, sabqi, manzil, ayatstart, ayatend);
                }
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();


        return studentdet;
    }
}
