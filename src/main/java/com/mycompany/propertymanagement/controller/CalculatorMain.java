package com.mycompany.propertymanagement.controller;

public class CalculatorMain {
    public static void main(String[] args){
        CalculatorController cc = new CalculatorController();
        Double result = cc.add(14.3,8.5);
        System.out.println(result);
    }
}
