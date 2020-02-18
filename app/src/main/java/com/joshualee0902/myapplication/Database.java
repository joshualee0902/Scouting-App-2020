package com.joshualee0902.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "info.db";
    public static final String TABLE_NAME = "data";
    public static final String COL_1 = "TEAM_NUM";
    public static final String COL_2 = "MATCH_NUM";
    public static final String COL_3 = "OUTCOME";
    public static final String COL_4 = "CROSS_LINE";
    public static final String COL_5 = "AUTO_UPPER";
    public static final String COL_6 = "AUTO_LOWER";
    public static final String COL_7 = "TELE_UPPER";
    public static final String COL_8 = "TELE_LOWER";
    public static final String COL_9 = "WHEEL_SPIN";
    public static final String COL_10 = "WHEEL_COLOR";
    public static final String COL_11 = "CLIMB";
    public static final String COL_12 = "FOULS";
    public static final String COL_13 = "TOTAL_POINTS";
    public static final String COL_14 = "RANKING_POINTS";
    public static final String COL_15 = "BRICKED";
    public static final String COL_16 = "COMMENT";

    public Database(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
        //SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+ TABLE_NAME + " (" + COL_1 + " INTEGER, " + COL_2 + " INTEGER, " + COL_3 + " TEXT, " + COL_4 + " TEXT, " + COL_5 + " INTEGER, " + COL_6 + " INTEGER, " + COL_7 + " INTEGER, " + COL_8 + " INTEGER, " + COL_9 + " TEXT, " + COL_10 + " TEXT, " + COL_11 + " TEXT, " + COL_12 + " TEXT, " + COL_13 + " INTEGER, " + COL_14 + " INTEGER, " + COL_15 + " TEXT, " + COL_16 + " TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String teamNum, String matchNum, String outcome, String crossLine, String autoUpper, String autoLower, String teleUpper, String teleLower, String wheelSpin, String wheelColor, String climb, String fouls, String totalPoints, String rankingPoints, String bricked, String comment) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, teamNum);
        contentValues.put(COL_2, matchNum);
        contentValues.put(COL_3, outcome);
        contentValues.put(COL_4, crossLine);
        contentValues.put(COL_5, autoUpper);
        contentValues.put(COL_6, autoLower);
        contentValues.put(COL_7, teleUpper);
        contentValues.put(COL_8, teleLower);
        contentValues.put(COL_9, wheelSpin);
        contentValues.put(COL_10, wheelColor);
        contentValues.put(COL_11, climb);
        contentValues.put(COL_12, fouls);
        contentValues.put(COL_13, totalPoints);
        contentValues.put(COL_14, rankingPoints);
        contentValues.put(COL_15, bricked);
        contentValues.put(COL_16, comment);

        long res = db.insert(TABLE_NAME, null, contentValues);
        if (res == -1) {
            return false;
        }
        return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return res;
    }


}
