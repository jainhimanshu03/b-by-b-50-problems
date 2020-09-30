package com.hj.coding;


public class Singleton {

    private static Singleton single_instance = new Singleton();

    private Singleton(){}

    public static Singleton getInstance(){
        return single_instance;
    }
}