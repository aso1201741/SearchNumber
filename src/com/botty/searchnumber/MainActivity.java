package com.botty.searchnumber;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
import android.database.Cursor;


public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void SwitchTranslate(View v){
		EditText et = (EditText)findViewById(R.id.display);
		TextView tv = (TextView)findViewById(R.id.display2);
		TextView tv2 = (TextView)findViewById(R.id.display3);
		
		String s = et.getText().toString();
		String a = s.substring(0, 3);
		String b = s.substring(3, 6);
		String c = s.substring(6, 8);
		String d = s.substring(8);
		String result = null;
		String result2 = null;
		
		switch(Integer.parseInt(a)){
		case 911: a = "����"; break;
		case 912: a = "�k��B"; break;
		case 913: a = "�v����"; break;
		case 922: a = "����"; break;
		case 931: a = "����"; break;
		case 932: a = "������"; break;
		case 942: a = "�F�{"; break;
		case 951: a = "�啪"; break;
		case 961: a = "�{��"; break;
		case 972: a = "������"; break;
		default: a = "0"; break;
		}
		
		if(a.equals("0")){
			result = "���i���o�[���s���ł��B";
		}else{
			result = a + b + " �� " + c + " - " + d;
			DBAccess da = new DBAccess(this);
			android.database.sqlite.SQLiteDatabase db = da.getReadableDatabase();
			String sql = "SELECT * FROM cdata WHERE id = '" + et.getText().toString() + "'";
			Cursor cr = db.rawQuery(sql,null);
			boolean eof = cr.moveToFirst();
			while(eof){
				result2 = cr.getString(1) + cr.getString(2);
				eof = cr.moveToNext();
			}
			cr.close();
			db.close();
		}
		tv.setText(result);
		tv2.setText(result2);
	}
	
	public void switchNC(View v){
		Intent vIntent = new Intent(this,NewCar.class);
		startActivity(vIntent);
	}
	public void switchSC(View v){
		Intent vIntent = new Intent(this,SearchCar.class);
		startActivity(vIntent);
	}
	public void switchAC(View v){
		Intent vIntent = new Intent(this,NewNumber.class);
		startActivity(vIntent);
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
