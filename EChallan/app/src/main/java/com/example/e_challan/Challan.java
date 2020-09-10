package com.example.e_challan;

import android.widget.Toast;

import java.io.Serializable;

public class Challan implements Serializable {
    String ch_no;
    String lic_no;
    String Name;
    String place;
    String rules;
    String rc_no;
    String total_fee;
    String email;

    Challan(){

    }
    void putVal(String ch_no,String lic_no,String Name,String place,String rules,String rc_no,String total_fee,String email){
        this.ch_no = ch_no;
        this.lic_no = lic_no;
        this.Name = Name;
        this.place = place;
        this.rules = rules;
        this.rc_no = rc_no;
        this.total_fee = total_fee;
        this.email = email;
    }
}
