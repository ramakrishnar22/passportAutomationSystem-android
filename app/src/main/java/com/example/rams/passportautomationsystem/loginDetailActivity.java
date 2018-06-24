package com.example.rams.passportautomationsystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class loginDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_detail);
        setTextViewProcess();
    }
    void setTextViewProcess(){
        TextView name=findViewById(R.id.textView19);
        TextView adno=findViewById(R.id.textView20);
        TextView add=findViewById(R.id.textView22);
        TextView dob=findViewById(R.id.textView23);
        TextView nat=findViewById(R.id.textView21);

        String dname=getIntent().getStringExtra("name");
        String dadno=getIntent().getStringExtra("aadharno");
        String dadd=getIntent().getStringExtra("address");
        String ddob=getIntent().getStringExtra("dob");

        name.setText(dname);
        adno.setText(dadno);
        add.setText(dadd);
        dob.setText(ddob);
        nat.setText("India");

    }
}
