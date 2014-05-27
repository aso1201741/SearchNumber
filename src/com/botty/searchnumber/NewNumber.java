package com.botty.searchnumber;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.EditText;
import android.content.Intent;

public class NewNumber extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.new_number);
		Intent vIntent = getIntent();
		String num = vIntent.getStringExtra("NUM");
		((EditText)findViewById(R.id.nnumber1)).setText(num);
		Spinner vspinner = (Spinner)findViewById(R.id.nnspinner1);
		System.out.println("**********************");
		vspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
				String cl = parent.getSelectedItem().toString();
				DBAccess da = new DBAccess(NewNumber.this);
				android.database.sqlite.SQLiteDatabase db = da.getReadableDatabase();
				
				String sql = "SELECT * FROM cname WHERE cl = '" + cl + "'";
				Cursor cr = db.rawQuery(sql,null);
				
				ArrayAdapter<String> ad
	            = new ArrayAdapter<String>(NewNumber.this, R.layout.rowdata);
				ad.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
				boolean eof = cr.moveToFirst();
				while(eof){
					ad.add(cr.getString(3));
					eof = cr.moveToNext();
				}
				cr.close();
				db.close();
				Spinner vspinner = (Spinner)findViewById(R.id.nnspinner2);
				
				vspinner.setAdapter(ad);

			}
			@Override
			public void onNothingSelected(AdapterView<?> parent){
				
			}
		});
	}

	public void switchA(View v){
		DBAccess da = new DBAccess(this);
		android.database.sqlite.SQLiteDatabase db = da.getReadableDatabase();
		
		Spinner vspinner = (Spinner)findViewById(R.id.nnspinner1);
		String cl = vspinner.getSelectedItem().toString();
		vspinner = (Spinner)findViewById(R.id.nnspinner2);
		String cname = vspinner.getSelectedItem().toString();
		EditText et = (EditText)findViewById(R.id.nnumber1);
		String number = et.getText().toString();
		
		String sql = "INSERT INTO cdata(id,cl,name) VALUES('" + number + "','" + cl + "','" + cname + "')";
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
