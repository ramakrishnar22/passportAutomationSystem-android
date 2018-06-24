package com.example.rams.passportautomationsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class signUpActivity extends AppCompatActivity {
 EditText dname,dadno,ddob,dadd;
 Button nextClick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getApplicantData();
    }
    void getApplicantData(){
            dname=findViewById(R.id.udname);
            dadno=findViewById(R.id.udadno);
            ddob=findViewById(R.id.uddob);
            dadd=findViewById(R.id.udadd);
            nextClick=findViewById(R.id.btnnext);

            nextClick.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String name=dname.getText().toString();
                    String adhaarno=dadno.getText().toString();
                    String dob=ddob.getText().toString();
                    String add=dadd.getText().toString();

                    Intent o=new Intent(signUpActivity.this,signUp2Activity.class);
                    o.putExtra("name",name);
                    o.putExtra("aadharno",adhaarno);
                    o.putExtra("dob",dob);
                    o.putExtra("address",add);
                    startActivity(o);

                }
            });

    }
}
