package com.phongth163965.ex6;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class EX6SQLiteHelper extends SQLiteOpenHelper {
    public static final String SQL_CREATE_TABLE_SANPHAM =
            "CREATE TABLE sanpham (" +
                    "masp TEXT PRIMARY KEY, " +
                    "tensp TEXT, " +
                    "soLuongSP TEXT)";

    public EX6SQLiteHelper(Context context) {
        super(context, "QLSP", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_SANPHAM);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS sanpham");
        onCreate(db);
    }
}
