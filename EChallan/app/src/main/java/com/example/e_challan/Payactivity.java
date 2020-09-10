package com.example.e_challan;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class Payactivity extends AppCompatActivity {

    HashMap<String,Challan> LoginMap = new HashMap<String, Challan>();
    EditText ed11,ed12,ed13,ed14,ed15;
    TextView challan_number,license_no,rule,vehicle_number,name,total_amount;
    String key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payactivity);

        getSupportActionBar().hide();

        Intent intent = getIntent();
        if (intent.getExtras() != null) {
//            String[] keys = extras.getStringArray("keys");
//            String[] vals = extras.getStringArray("vals");
//            int i = 0;                                                          //ask this part
//            for (i = 0; i < keys.length; i++) {
//                payLoginDetails.put(keys[i], vals[i]);
            LoginMap = (HashMap<String,Challan>)intent.getSerializableExtra("map");
            key = intent.getExtras().getString("key");
        }
        set();

    }

    public void set(){

        challan_number = (TextView) findViewById(R.id.challan_no1);
        license_no = (TextView) findViewById(R.id.License_no1);
        name = (TextView) findViewById(R.id.name_11);
        rule = (TextView) findViewById(R.id.rule_broken1);
        vehicle_number = (TextView) findViewById(R.id.vehicle_rc_no1);
        total_amount = (TextView) findViewById(R.id.total_amount1);

        challan_number.setText(LoginMap.get(key).ch_no);
        license_no.setText(LoginMap.get(key).ch_no);
        name.setText(LoginMap.get(key).Name);
        rule.setText(LoginMap.get(key).rules);
        vehicle_number.setText(LoginMap.get(key).rc_no);
        total_amount.setText(LoginMap.get(key).total_fee);


    }
//    public void checkbtn(View view)
//    {
//        ed11 = (EditText) findViewById(R.id.edit11);
//        challan_number = ed11.getText().toString();
//
//    }

    public void toaster2()
    {
        Context context = getApplicationContext();
        CharSequence text = "Challan payed";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context,text,duration);
        toast.show();
    }

    public void toaster4()
    {
        Context context = getApplicationContext();
        CharSequence text = "Payment cancelled";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context,text,duration);
        toast.show();
    }


    public void payfinal(View  view)
    {
        //String[] details = Issueactivity.detailList.get(challan_number);
//        ed12 = (EditText) findViewById(R.id.edit12);
//        ed13 = (EditText) findViewById(R.id.edit13);
//        ed14 = (EditText) findViewById(R.id.edit14);
//        ed15 = (EditText) findViewById(R.id.edit15);

//        license_no = details[0];
//        name = details[1];
//        rule_broken = details[6];
//        vehicle_number = details[7];

//        license_no = ed12.getText().toString();
//        name = ed13.getText().toString();
//        rule_broken = ed14.getText().toString();
//        vehicle_number = ed15.getText().toString();

        //ed13.setText(challan_number);

        toaster2();
        Intent home = new Intent(this, MainActivity.class);
        home.putExtra("map",LoginMap);
        home.putExtra("p",12);
        startActivity(home);
    }

    public void Back_to_home(View view)
    {

        Intent home = new Intent(this, MainActivity.class);
        home.putExtra("map",LoginMap);
        home.putExtra("p",12);
        toaster4();
        startActivity(home);
    }
}
