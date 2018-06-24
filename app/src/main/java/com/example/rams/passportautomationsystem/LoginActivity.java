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

public class LoginActivity extends AppCompatActivity {
    EditText username,password;
    Button login,signUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        performLoginCheck();

    }
    void performLoginCheck(){
        username= findViewById(R.id.udname);
        password= findViewById(R.id.upass);
        login=findViewById(R.id.btnlogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String name=username.getText().toString();
                final String pass=password.getText().toString();

                DatabaseReference database= FirebaseDatabase.getInstance().getReference();

                database.child("profile").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        final int[] t = new int[1];
                        t[0] = 0;
                        for(DataSnapshot findKeyValue : dataSnapshot.getChildren()) {
                            if (findKeyValue.child("username").getValue() != null && findKeyValue.child("password").getValue() != null) {
                                String nameFound = (String) findKeyValue.child("username").getValue();
                                String passwordFound = (String) findKeyValue.child("password").getValue();
                                System.out.println(nameFound);
                                System.out.println(passwordFound);
                                System.out.println(name);
                                System.out.println(pass);
                                if (name.equals(nameFound)) {
                                    System.out.println("true");
                                    if (pass.equals(passwordFound)) {
                                        System.out.println("true go");
                                        t[0] =1;
                                        System.out.println(t[0]);
                                        break;
                                    }
                                }
                            }
                        }
                        if(t[0] == 1) {
                            Toast text = Toast.makeText(getApplicationContext(),"Hello,world", Toast.LENGTH_LONG);
                            text.show();
                            Intent o= new Intent(LoginActivity.this,StatusActivity.class);
                            startActivity(o);

                        }
                        else{
                            Toast text = Toast.makeText(getApplicationContext(),"Hello,loser", Toast.LENGTH_LONG);
                            text.show();
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

