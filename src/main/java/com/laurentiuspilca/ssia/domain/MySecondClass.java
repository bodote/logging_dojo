package com.laurentiuspilca.ssia.domain;

public class MySecondClass {
    private final int constant;

    public MySecondClass(int constant) {
        this.constant = constant;
    }

    public int qubed(int value){
        return value*value*constant;
    }
}
