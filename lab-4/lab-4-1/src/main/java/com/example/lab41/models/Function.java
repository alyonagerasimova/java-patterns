package com.example.lab41.models;

public class Function {
    private static final Function func = new Function();

    private Function(){}

    public Double calculateY(double x){
        return Math.pow(x, 3)/2 - 3 * Math.pow(x, 2)+ 1 ;
    }

    public static Function getInstance() {
        return func;
    }
}
