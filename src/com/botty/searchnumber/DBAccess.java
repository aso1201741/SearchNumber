package com.botty.searchnumber;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;

public class DBAccess extends SQLiteOpenHelper{
	public DBAccess(Context context){
		super(context,"sample.db",null,1);
	}
	@Override
	public void onCreate(SQLiteDatabase arg0){
		String sql = "CREATE TABLE cname(id integer primary key, number text, cl text, name text);";
		arg0.execSQL(sql);
		sql = "CREATE TABLE cdata(id integer primary key, cl text, name text);";
		arg0.execSQL(sql);
	}
	@Override
	public void onUpgrade(SQLiteDatabase sqlitedatabase,int i,int j){
		
	}
}