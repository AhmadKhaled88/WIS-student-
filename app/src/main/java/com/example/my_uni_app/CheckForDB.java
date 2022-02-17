package com.example.my_uni_app;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import org.jetbrains.annotations.NotNull;

public class CheckForDB implements DatabaseReference.CompletionListener {
    String check1 ;
    String check2 ;
    String check3 ;
    String check4 ;
    String check5 ;
    String check6 ;
    String check7 ;


    public CheckForDB(){

    }

    public CheckForDB(String check1, String check2, String check3, String check4, String check5, String check6, String check7) {
        this.check1 = check1;
        this.check2 = check2;
        this.check3 = check3;
        this.check4 = check4;
        this.check5 = check5;
        this.check6 = check6;
        this.check7 = check7;
    }

    public String getCheck1() {
        return check1;
    }

    public void setCheck1(String check1) {
        this.check1 = check1;
    }

    public String getCheck2() {
        return check2;
    }

    public void setCheck2(String check2) {
        this.check2 = check2;
    }

    public String getCheck3() {
        return check3;
    }

    public void setCheck3(String check3) {
        this.check3 = check3;
    }

    public String getCheck4() {
        return check4;
    }

    public void setCheck4(String check4) {
        this.check4 = check4;
    }

    public String getCheck5() {
        return check5;
    }

    public void setCheck5(String check5) {
        this.check5 = check5;
    }

    public String getCheck6() {
        return check6;
    }

    public void setCheck6(String check6) {
        this.check6 = check6;
    }

    public String getCheck7() {
        return check7;
    }

    public void setCheck7(String check7) {
        this.check7 = check7;
    }

    @Override
    public void onComplete(@Nullable @org.jetbrains.annotations.Nullable DatabaseError error, @NonNull @NotNull DatabaseReference ref) {

    }
}