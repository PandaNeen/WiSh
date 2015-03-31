package com.example.locationdetecting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {
	  LocationManager lm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        
        Boolean enabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
        
        if(!enabled){
        	Intent intent = new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
        	startActivity(intent);
        }
        
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10000, 1000, listener);
        
        
        if(lm == null) {
            Toast.makeText(this, "Device isn't support location", Toast.LENGTH_SHORT).show();
            finish();
        }
        else{
        	Toast.makeText(this, "support location", Toast.LENGTH_SHORT).show();
        }
	}
	
	 private final LocationListener listener = new LocationListener() {
	        public void onLocationChanged(Location location) {
	         //   textLatitude.setText(String.format("%.7f", location.getLatitude()));
	          //  textLongitude.setText(String.format("%.7f",location.getLongitude()));
	        }

	        public void onProviderDisabled(String provider) { }
	        public void onProviderEnabled(String provider) { }
	        public void onStatusChanged(String provider, int status, Bundle extras) { }
	    };

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
