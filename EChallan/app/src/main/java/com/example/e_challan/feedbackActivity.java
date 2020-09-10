package com.example.e_challan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class feedbackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        getSupportActionBar().hide();

        Button btn2 = (Button) findViewById(R.id.send_dis);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"ateendrasrivastava@gmail.com"});
                email.putExtra(Intent.EXTRA_SUBJECT, "Feedback");
                email.putExtra(Intent.EXTRA_TEXT, getfeedback());
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "ateendrasrivastav@gmail.com"));
            }
        });


    }

    String feed1;
    public String getfeedback()
    {
        EditText feed = (EditText) findViewById(R.id.getfeed);
        feed1 = feed.getText().toString();
        return feed1;
    }
    public void Back_to_home(View view)
    {

        Intent home = new Intent(this, MainActivity.class);
        startActivity(home);
    }
}
