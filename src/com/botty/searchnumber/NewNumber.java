package com.botty.searchnumber;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;
import android.widget.EditText;


public class NewNumber extends Activity implements OnItemSelectedListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.new_number);
		Spinner vspinner = (Spinner)findViewById(R.id.spinner1);
		vspinner.setOnItemSelectedListener(onItemSelected());
	}
	
	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}

	public void switchA(View v){
		DBAccess2 da = new DBAccess2(this);
		android.database.sqlite.SQLiteDatabase db = da.getReadableDatabase();
		
		Spinner vspinner = (Spinner)findViewById(R.id.spinner1);
		String cl = vspinner.getSelectedItem().toString();
		vspinner = (Spinner)findViewById(R.id.spinner2);
		String cname = vspinner.getSelectedItem().toString();
		EditText et = (EditText)findViewById(R.id.nnumber1);
		String number = et.getText().toString();
		
		String sql = "INSERT INTO cdata VALUES('" + number + "','" + cl + "','" + cname + "')";
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
