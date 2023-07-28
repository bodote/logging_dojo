package com.laurentiuspilca.ssia.domain;

public class MyFirstClass {
    private final int constant;

    public MyFirstClass(int constant) {
        this.constant = constant;
    }
    public int timesTwo(int value){
        return value*2*constant;
    }
}
