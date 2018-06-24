package com.example.rams.passportautomationsystem;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class User {
    public String name;
    public String aadharno;
    public String dob;
    public String address;
    public String phone;
    public String gender;
    public String isAadhaar;
    public String isPan;
    public String isVoter;
    public String isbirthcer;

    public User(){

    }
    public User(String name,String aadharno,String dob,String address,String phone,String gender,String isAadhaar,String isPan,String isVoter,String isbirthcer){
        this.name=name;
        this.aadharno=aadharno;
        this.address=address;
        this.dob=dob;
        this.phone=phone;
        this.gender=gender;
        this.isAadhaar=isAadhaar;
        this.isPan=isPan;
        this.isVoter=isVoter;
        this.isbirthcer=isbirthcer;
    }

}
