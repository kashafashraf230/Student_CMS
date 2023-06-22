package com.example.hafiz_lms;


public class Details {
    private int roll;
    private String surah;
    private int sabqi;
    private int manzil;
    private int ayatStart;
    private int ayatEnd;


    public Details(){
        roll = 1;
        surah="";
        sabqi=0;
        manzil=0;
        ayatStart=1;
        ayatEnd=1;
    }

    public Details(int roll, String surah, int sabqi, int manzil, int ayatStart, int ayatEnd){
        this.roll=roll;
        this.surah=surah;
        this.sabqi=sabqi;
        this.manzil=manzil;
        this.ayatEnd=ayatEnd;
        this.ayatStart=ayatStart;
    }

    public int getRoll() {
        return roll;
    }

    public int getAyatEnd() {
        return ayatEnd;
    }

    public int getAyatStart() {
        return ayatStart;
    }

    public int getManzil() {
        return manzil;
    }

    public String getSurah() {
        return surah;
    }

    public int getSabqi() {
        return sabqi;
    }

    public void setAyatEnd(int ayatEnd) {
        this.ayatEnd = ayatEnd;
    }

    public void setAyatStart(int ayatStart) {
        this.ayatStart = ayatStart;
    }

    public void setManzil(int manzil) {
        this.manzil = manzil;
    }

    public void setSurah(String surah) {
        this.surah = surah;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public void setSabqi(int sabqi) {
        this.sabqi = sabqi;
    }
}
