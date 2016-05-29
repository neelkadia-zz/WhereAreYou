package com.thetwon.whereareyou;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    public static final String RECEIVE_JSON = "com.thetwon.whereareyou.RECEIVE_JSON";
    Button btnLocationSharing;
    TextView txtCoordinates, txtAddress;
    Double Latitude, Longitude;
    String Provider;
    BroadcastReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initReference();
        initListener();

        receiver  = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if(intent.getAction().equals(RECEIVE_JSON)) {
                    Provider = intent.getStringExtra("Provider");
                    Latitude =(Double) intent.getExtras().get("Latitude");
                    Longitude =(Double) intent.getExtras().get("Longitude");
                    //Provider =(String) intent.getExtras().get("Provider");
                    txtAddress.setText("Provider : "+Provider);
                    txtCoordinates.setText("Lat:" + Latitude + " ,Long:" + Longitude);

                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRef = database.getReference("geometry").child("coordinates");
                    myRef.child("0").setValue(Latitude);
                    myRef.child("1").setValue(Longitude);
                }
            }
        };

        LocalBroadcastManager bManager = LocalBroadcastManager.getInstance(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(RECEIVE_JSON);
        bManager.registerReceiver(receiver, intentFilter);

    }

    private void initReference() {
        btnLocationSharing = (Button)findViewById(R.id.btnLocationSharing);
        txtAddress = (TextView) findViewById(R.id.txtAddress);
        txtCoordinates = (TextView) findViewById(R.id.txtCoordinates);
    }

    private void initListener() {
        btnLocationSharing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btnLocationSharing.getText().toString().equalsIgnoreCase("Start location sharing")){
                    Intent intent = new Intent(MainActivity.this, LocationService.class);
                    startService(intent);
                    btnLocationSharing.setText("Stop location sharing");
                }else{
                    btnLocationSharing.setText("Start location sharing");
                    android.os.Process.killProcess(android.os.Process.myPid());
                }
            }
        });
        txtAddress = (TextView) findViewById(R.id.txtAddress);
        txtCoordinates = (TextView) findViewById(R.id.txtCoordinates);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
