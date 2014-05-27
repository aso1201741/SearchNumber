package com.botty.searchnumber;

import android.os.Bundle;
import android.content.Intent;
import android.app.Activity;
import android.database.Cursor;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;


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
		ArrayAdapter<String> ad = new ArrayAdapter<String>(this, R.layout.rowdata2);
		boolean eof = cr.moveToFirst();
		while(eof){
			ad.add(cr.getString(2) + " " + cr.getString(3));
			eof = cr.moveToNext();
		}
		cr.close();
		db.close();
		ListView vlistview = (ListView)findViewById(R.id.scar_result);
		vlistview.setAdapter(ad);
		vlistview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
	        @Override
	        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
	        	DBAccess da = new DBAccess(SearchCar.this);
	    		android.database.sqlite.SQLiteDatabase db = da.getReadableDatabase();
	    		ListView listView = (ListView) parent;
                String item = (String) listView.getItemAtPosition(position);
                item = item.substring(4,item.length());
	        	String sql = "DELETE FROM cname WHERE name = '" + item + "'";
	    		db.execSQL(sql);
	    		db.close();
	    		switchS(view);
	            return false;
	        }
	    });
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()){
		case R.id.action_newcar:
			Intent vIntent = new Intent(this,NewCar.class);
			startActivity(vIntent);
			return true;
		}
		return false;
	}


}
