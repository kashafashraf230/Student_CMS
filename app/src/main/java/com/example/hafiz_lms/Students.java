package com.example.hafiz_lms;


public class Students {
    private String name;
    private int age;
    private int clas;

    private int roll;




    public Students(String name, int age, int c, int roll) {
        this.name = name;
        this.age = age;
        this.clas = c;
        this.roll = roll;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public int getClas() {
        return clas;
    }

    public void setClass(int clas) {
        this.clas = clas;
    }

}
