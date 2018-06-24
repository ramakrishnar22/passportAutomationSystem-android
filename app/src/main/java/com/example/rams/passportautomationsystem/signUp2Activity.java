package com.example.rams.passportautomationsystem;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;

public class signUp2Activity extends AppCompatActivity {
        EditText dphone;
        RadioButton radioButton;
        RadioGroup radioGroup;
        Button Final;
        CheckBox adno,pan,voter,birth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2);
        finalEditConfig();
    }
    void finalEditConfig(){
        adno=findViewById(R.id.isAadhaar);
        pan=findViewById(R.id.isPan);
        voter=findViewById(R.id.isVoter);
        birth=findViewById(R.id.isbirthcer);
            radioGroup=findViewById(R.id.checksex);
        dphone=findViewById(R.id.udphone);
        Final=findViewById(R.id.Done);

        Final.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference database= FirebaseDatabase.getInstance().getReference();
                int selectedId=radioGroup.getCheckedRadioButtonId();
                radioButton=findViewById(selectedId);
                String gender=radioButton.getText().toString();
                String phone=dphone.getText().toString();
                String name=getIntent().getStringExtra("name");
                String aadharno=getIntent().getStringExtra("aadharno");
                String dob=getIntent().getStringExtra("dob");
                String address=getIntent().getStringExtra("address");
                String isAadhaar,isPan,isVoter,isbirthcer;
                if(adno.isChecked())
                    isAadhaar="yes";
                else
                    isAadhaar="no";
                if(pan.isChecked())
                    isPan="yes";
                else
                    isPan="no";
                if(voter.isChecked())
                    isVoter="yes";
                else
                    isVoter="no";
                if(birth.isChecked())
                    isbirthcer="yes";
                else
                    isbirthcer="no";
                int min=1,max=1000;
                Random ran=new Random();
                int w=min+ran.nextInt(max);
                User user=new User(name,aadharno,dob,address,phone,gender,isAadhaar,isPan,isVoter,isbirthcer);
                database.child("applicant").push().setValue(user);
                Toast text=Toast.makeText(getApplicationContext(),"Inserted Successfully",Toast.LENGTH_SHORT);
                text.show();
                Intent o=new Intent(signUp2Activity.this,StatusActivity.class);
                startActivity(o);

            }
        });


    }
}
