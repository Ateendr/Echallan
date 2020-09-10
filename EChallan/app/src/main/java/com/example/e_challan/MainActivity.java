package com.example.e_challan;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends Activity {


    HashMap<String,Challan> LoginMap = new HashMap<String, Challan>();
    String TAG = "beta";
    EditText ed1, ed2;
    String b1,b2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       // Bundle extras = getIntent().getExtras();
        Intent intent = getIntent();
        if (intent.getExtras() != null) {
//            String[] keys = extras.getStringArray("keys");
//            String[] vals = extras.getStringArray("vals");
//            int i = 0;                                                          //ask this part
//            for (i = 0; i < keys.length; i++) {
//                payLoginDetails.put(keys[i], vals[i]);
            LoginMap = (HashMap<String,Challan>)intent.getSerializableExtra("map");
            }


    }

    public void toaster()
    {
        Context context = getApplicationContext();
        CharSequence text = "Invalid username or password";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context,text,duration);
        toast.show();
    }


    public void issue_works(View view) {
        Map<String,String> issueLoginDetails = new HashMap<String, String>();
        issueLoginDetails.put("a", "b");
        issueLoginDetails.put("onkar", "akash");
        issueLoginDetails.put("ateen", "ateen");


        ed1 = (EditText) findViewById(R.id.edit1);
        ed2 = (EditText) findViewById(R.id.edit2);

        b1 = ed1.getText().toString();
        b2 = ed2.getText().toString();

        if (!issueLoginDetails.containsKey(b1)) {           //the condition here??
            toaster();
        }
        else if (!issueLoginDetails.get(b1).equals(b2)){
            toaster();
          }
        else {
//            Intent startnewactivity1 = new Intent(this, Issueactivity.class);
//            startActivity(startnewactivity1);
//            String[] keys = new String[payLoginDetails.size()];
//            String[] vals = new String[payLoginDetails.size()];
//            int k =0;                                                   //this part also ask
//            for(String s: payLoginDetails.keySet()){
//                keys[k] = s;
//                vals[k] = payLoginDetails.get(s);
//                k += 1;
//            }
//
//            String[] detKeys = new String[detailList.size()];
//            String[] detVals = new String[detailList.size()];
//            k=0;
//            for(String s: detailList.keySet()){
//                detKeys[k] = s;
//                detVals[k] = "";
//                for(String i: detailList.get(s))
//                    detVals[k] += "@"+i;
//            }
            Intent startnewactivity1 = new Intent(this, Issueactivity.class);
//            startnewactivity1.putExtra("keys",keys);
//            startnewactivity1.putExtra("vals",vals);
            LoginMap.put("44",new Challan());
            Log.d(TAG,"ma 1");
            startnewactivity1.putExtra("map",LoginMap);
            startnewactivity1.putExtra("etc",1);
            Log.d(TAG,"ma 1");
            startActivity(startnewactivity1);
        }


    }

    //Map<String,String> payLoginDetails = new HashMap<String, String>();
   // Map<String,String[]> detailList = new HashMap<String,String[]>();

    public void pay_works(View view)
    {
    
        ed1 = (EditText) findViewById(R.id.edit1);
        ed2 = (EditText) findViewById(R.id.edit2);

        b1 = ed1.getText().toString();
        b2 = ed2.getText().toString();


        if (!LoginMap.containsKey(b1)) {
            toaster();
        }
        else if (!LoginMap.get(b1).Name.equals(b2))
        {
            toaster();
        }
        else {

            Intent startnewactivity2 = new Intent(this, Payactivity.class);
            startnewactivity2.putExtra("map",LoginMap);
            startnewactivity2.putExtra("key",b1);
            startActivity(startnewactivity2);
        }


    }

    public void feedback(View view)
    { Intent feedbackstore = new Intent(this, feedbackActivity.class);
      startActivity(feedbackstore);
    }


}