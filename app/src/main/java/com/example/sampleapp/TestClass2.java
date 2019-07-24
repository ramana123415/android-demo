package com.example.sampleapp;

public class TestClass2 {


    int k = 0;

    private static final TestClass2 ourInstance = new TestClass2();


    public static TestClass2 getInstance() {
        return ourInstance;
    }

    private TestClass2() {
    }

    public int addNumbers(){
        k = 30+10 + k;
        return k;
    }
}
