package com.botty.searchnumber;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.view.Menu;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;


public class SearchCar extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search_car);
		
	}
	
	public void switchS(View v){
		DBAccess da = new DBAccess(this);
		android.database.sqlite.SQLiteDatabase db = da.getReadableDatabase();
		
		Spinner vspinner = (Spinner)findViewById(R.id.spinner2);
		String cl = vspinner.getSelectedItem().toString();
		
		String sql = "SELECT * FROM cname WHERE cl = '" + cl + "'";
		Cursor cr = db.rawQuery(sql,null);
		boolean eof = cr.moveToFirst();
		String result = null;
		while(eof){
			result = result + cr.getString(0) + cr.getString(1) + cr.getString(2) + "\n";
			eof = cr.moveToNext();
		}
		cr.close();
		db.close();
		
		TextView tv = (TextView)findViewById(R.id.scar_result);
		tv.setText(result);
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
