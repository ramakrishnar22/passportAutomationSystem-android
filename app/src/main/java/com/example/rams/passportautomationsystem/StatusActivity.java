package com.example.rams.passportautomationsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class StatusActivity extends AppCompatActivity {
    EditText dname;
    Button checker,adder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);
        performCheck();
    }
    void performCheck(){
        dname=findViewById(R.id.chkname);
        checker=findViewById(R.id.chker);
        adder=findViewById(R.id.addpass);
        adder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent o=new Intent(StatusActivity.this,signUpActivity.class);
                startActivity(o);
            }
        });
        checker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String name=dname.getText().toString();
                DatabaseReference database= FirebaseDatabase.getInstance().getReference();
                database.child("applicant").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        final int t[]=new int[1];
                        t[0]=2;
                        final String[] adno =new String[1];
                        final String[] dob =new String[1];
                        final String[] add =new String[1];
                        for (DataSnapshot childDataSnapshot : dataSnapshot.getChildren()) {
                            if (childDataSnapshot.child("name").getValue() != null) {
                                String newName = childDataSnapshot.child("name").getValue().toString();
                                if (name.equals(newName)) {
                                     adno[0]=childDataSnapshot.child("aadharno").getValue().toString();
                                      dob[0]=childDataSnapshot.child("dob").getValue().toString();
                                      add[0]=childDataSnapshot.child("address").getValue().toString();
                                        t[0]=1;
                                        break;
                                }
                            }
                        }
                        if(t[0]==1){
                            Intent o = new Intent(StatusActivity.this, loginDetailActivity.class);
                            o.putExtra("name", name);
                            o.putExtra("aadharno",adno[0]);
                            o.putExtra("address",add[0]);
                            o.putExtra("dob",dob[0]);
                            startActivity(o);

                        }else if(t[0]==0){
                            Toast text = Toast.makeText(getApplicationContext(), "Data not Available", Toast.LENGTH_SHORT);
                            text.show();
                            Intent o = new Intent(StatusActivity.this, signUpActivity.class);
                            startActivity(o);
                        }

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}
