package com.chen.seniortool.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 陈德东 on 2017/4/8 20:47
 * 描述:
 */

public class MyDataBaseHelp extends SQLiteOpenHelper {

    public static final String CREATE_BOOK = "create table book ("
            + "id integer primary key autoincrement, "//autoincrement关键字表示id列是自增长的
            + "author text, "//文本类型
            + "price real, "//浮点型
            + "pages integer, "//整型
            + "name text"
            + "category_id integer)";//添加了新的数据库

    public static final String CREATE_CATEGORY = "create table Category ("
            + "id integer primary key autoincrement, "
            + "category_name text, "
            + "category_code integer)";


    private Context mContext;


    /**
     * @param context
     * @param name    数据库名称
     * @param factory 可以为null
     * @param version 数据库版本号
     */
    public MyDataBaseHelp(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建时间:2017/4/8 20:51 描述:创建表
        db.execSQL(CREATE_BOOK);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        switch (oldVersion) {
            case 1:
                db.execSQL(CREATE_CATEGORY);
            case 2:
                db.execSQL("alter table Book add column category_id integer");
            default:
        }
    }
}
