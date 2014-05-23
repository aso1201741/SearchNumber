package com.botty.searchnumber;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;

public class DBAccess2 extends SQLiteOpenHelper{
	public DBAccess2(Context context){
		super(context,"sample.db",null,1);
	}
	@Override
	public void onCreate(SQLiteDatabase arg0){
		String sql = "CREATE TABLE cdata(id integer primary key, cl text, name text);";
		arg0.execSQL(sql);
	}
	@Override
	public void onUpgrade(SQLiteDatabase sqlitedatabase,int i,int j){
		
	}
}