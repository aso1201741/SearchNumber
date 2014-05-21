package com.botty.searchnumber;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Spinner;
import android.widget.EditText;


public class NewCar extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.new_car);
		
	}
	
	public void switchA(View v){
		DBAccess da = new DBAccess(this);
		android.database.sqlite.SQLiteDatabase db = da.getReadableDatabase();
		
		Spinner vspinner = (Spinner)findViewById(R.id.spinner1);
		String cl = vspinner.getSelectedItem().toString();
		EditText et = (EditText)findViewById(R.id.ncar_name);
		String cname = et.getText().toString();
		
		String sql = "INSERT INTO cname(cl,name) VALUES('" + cl + "','" + cname + "')";
		db.execSQL(sql);
		db.close();
		finish();
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
