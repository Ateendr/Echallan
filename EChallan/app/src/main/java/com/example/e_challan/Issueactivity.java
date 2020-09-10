package com.example.e_challan;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Calendar;
import java.text.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Issueactivity extends AppCompatActivity {

    HashMap<String,Challan> payLoginDetails = new HashMap<String, Challan>();
    EditText challan_number,license_number,name,place,date,time,rules,vehicle_number,total_amount,send_email;
    String a1,a2,a3,a4,a5,a6,a7,a8,a9,a10;
    String TAG = "beta";

    EditText datenew;//timenew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issueactivity);
        set();
        getSupportActionBar().hide();

       // Bundle extras = getIntent().getExtras();
        Intent intent = getIntent();
        if (intent.getExtras() != null) {
            payLoginDetails = (HashMap<String,Challan>)intent.getSerializableExtra("map");
            Toast t = Toast.makeText(getApplicationContext(),"recived no problem",Toast.LENGTH_SHORT);
            t.show();
            }

            Button btn1 = (Button) findViewById(R.id.sendissuemail);
            btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{getemail()});
                email.putExtra(Intent.EXTRA_SUBJECT, "Challan issued");
                email.putExtra(Intent.EXTRA_TEXT, "Dear driver, It is to inform you that a challan has been issued on your name with an amount of ₹"+amount()+" .You are requested to pay the challan through the E-challan app. The user id and password for your challan is UserID - "+ user_name() +" &  Password - "+pssw()+ " .Thank You!!!");
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "ateendrasrivastav@gmail.com"));
            }
            });

    }

    void set(){
        challan_number = (EditText) findViewById(R.id.challan_no);
        license_number = (EditText) findViewById(R.id.License_no);
        name = (EditText) findViewById(R.id.name_1);
        place = (EditText) findViewById(R.id.accident_place);
        //date = (EditText) findViewById(R.id.accident_date);
       // time = (EditText) findViewById(R.id.accident_time);
        rules = (EditText) findViewById(R.id.rule_broken);
        vehicle_number = (EditText) findViewById(R.id.vehicle_rc_no);
        total_amount = (EditText) findViewById(R.id.total_amount);
        send_email = (EditText) findViewById(R.id.email);

    }


    public void issue_challan_1(View view)
    {
        Challan ch = new Challan();
        Log.d(TAG,"0");
        set();
        a1 = challan_number.getText().toString();
        a2 = license_number.getText().toString();
        a3 = name.getText().toString();
        a4 = place.getText().toString();
        //a5 = date.getText().toString();
        //a6 = time.getText().toString();
        a7 = rules.getText().toString();
        a8 = vehicle_number.getText().toString();
        a9 = total_amount.getText().toString();
        a10 = send_email.getText().toString();
        Log.d(TAG,"1");

        ch.putVal(a1,a2,a3,a4,a7,a8,a9,a10);
        Log.d(TAG,"2");
        payLoginDetails.put(a1,ch);
        Log.d(TAG,"3");

        Intent startnewactivity2 = new Intent(this, MainActivity.class);
        Log.d(TAG,"4");
        startnewactivity2.putExtra("map",payLoginDetails);
        Log.d(TAG,"5");
        startnewactivity2.putExtra("etc",1);
        Log.d(TAG,"6");
        toaster1();
        Log.d(TAG,"7");
        startActivity(startnewactivity2);
    }

    @SuppressLint("SetTextI18n")
    public void get_date_time(View view)
    {
        datenew = (EditText) findViewById(R.id.show_date);
        //timenew = (TextView) findViewById(R.id.show_time);

        Date c = Calendar.getInstance().getTime();
       // System.out.println(c);

        //@SuppressLint("SimpleDateFormat") SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        //String formattedDate = df.format(c);

        datenew.setText(""+c);
        //timenew.setText(formattedDate);
    }

//    public void tme()
//    {
//        Date c = Calendar.getInstance().getTime();
//        System.out.println(c);
//
//        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
//        String formattedDate = df.format(c);
//    }



    public void toaster1()
    {
        Context context = getApplicationContext();
        CharSequence text = "Challan issued";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context,text,duration);
        toast.show();
    }

    public void toaster3()
    {
        Context context = getApplicationContext();
        CharSequence text = "Issue cancelled";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context,text,duration);
        toast.show();
    }

    public void Back_to_home(View view)
    {

        Intent home = new Intent(this, MainActivity.class);
        toaster3();
        startActivity(home);
    }

    String Email,user,pass,amnt;

    public String getemail()
    {
        EditText EMAIL = (EditText) findViewById(R.id.email);
        Email = EMAIL.getText().toString();

        return Email;

    }

    public String user_name()
    {
        EditText getusername = (EditText) findViewById((R.id.License_no));
        user = getusername.getText().toString();

        return user;
    }

    public String pssw()
    {
        EditText getpassname = (EditText) findViewById((R.id.name_1));
        pass = getpassname.getText().toString();

        return pass;
    }

    public String amount()
    {
        EditText getamount = (EditText) findViewById((R.id.total_amount));
        amnt = getamount.getText().toString();
        return amnt;
    }
}
