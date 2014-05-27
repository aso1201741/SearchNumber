package com.botty.searchnumber;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
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
		TextView et = (TextView)findViewById(R.id.display);
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
		case 911: a = "ïüâ™"; break;
		case 912: a = "ñkã„èB"; break;
		case 913: a = "ãvóØïƒ"; break;
		case 922: a = "ç≤âÍ"; break;
		case 931: a = "í∑çË"; break;
		case 932: a = "ç≤ê¢ï€"; break;
		case 942: a = "åFñ{"; break;
		case 951: a = "ëÂï™"; break;
		case 961: a = "ã{çË"; break;
		case 972: a = "é≠éôìá"; break;
		default: a = "0"; break;
		}
		
		if(a.equals("0")){
			result = "åßÉiÉìÉoÅ[Ç™ïsê≥Ç≈Ç∑ÅB";
		}else{
			result = a + b + " ÇÌ " + c + " - " + d;
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
	
	public void switchSC(View v){
		Intent vIntent = new Intent(this,SearchCar.class);
		startActivity(vIntent);
	}
	public void switchAC(View v){
		String s = ((TextView)findViewById(R.id.display)).getText().toString();
		int x = s.length();
		Intent vIntent = new Intent(this,NewNumber.class);
		if(x == 10){
			vIntent.putExtra("NUM", s);
		}
		startActivity(vIntent);
	}
	public void switchSN(View v){
		Intent vIntent = new Intent(this,SearchNumber.class);
		startActivity(vIntent);
	}
	
	public void switch1(View v){
		TextView et = (TextView)findViewById(R.id.display);
		et.setText(et.getText() + "1");
	}
	public void switch2(View v){
		TextView et = (TextView)findViewById(R.id.display);
		et.setText(et.getText() + "2");
	}
	public void switch3(View v){
		TextView et = (TextView)findViewById(R.id.display);
		et.setText(et.getText() + "3");
	}
	public void switch4(View v){
		TextView et = (TextView)findViewById(R.id.display);
		et.setText(et.getText() + "4");
	}
	public void switch5(View v){
		TextView et = (TextView)findViewById(R.id.display);
		et.setText(et.getText() + "5");
	}
	public void switch6(View v){
		TextView et = (TextView)findViewById(R.id.display);
		et.setText(et.getText() + "6");
	}
	public void switch7(View v){
		TextView et = (TextView)findViewById(R.id.display);
		et.setText(et.getText() + "7");
	}
	public void switch8(View v){
		TextView et = (TextView)findViewById(R.id.display);
		et.setText(et.getText() + "8");
	}
	public void switch9(View v){
		TextView et = (TextView)findViewById(R.id.display);
		et.setText(et.getText() + "9");
	}
	public void switch0(View v){
		TextView et = (TextView)findViewById(R.id.display);
		et.setText(et.getText() + "0");
	}
	public void switchBS(View v){
		TextView et = (TextView)findViewById(R.id.display);
		String s = et.getText().toString();
		if(et.length() != 0){
			et.setText(s.substring(0,s.length() - 1));
		}
	}
	public void switchEnter(View v){
		int x = ((TextView)findViewById(R.id.display)).getText().toString().length();
		if(x == 10){
			this.SwitchTranslate(v);
		}
	}
}
