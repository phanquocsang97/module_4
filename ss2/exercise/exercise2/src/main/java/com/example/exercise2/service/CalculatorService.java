package com.example.exercise2.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService{
    double totalCaculation = 0;
    @Override
    public String calculate(double numFirst, double numSecond, String input) {
        switch (input){
            case "Addition(+)":
                totalCaculation = numFirst + numSecond;
                return "Total Calculation : " + totalCaculation;
            case "Subtraction(-)":
                totalCaculation = numFirst - numSecond;
                return "Total Calculation : " + totalCaculation;
            case "Multiplication(*)":
                totalCaculation = numFirst * numSecond;
                return "Total Calculation : " + totalCaculation;
            case "Division(/)":
                totalCaculation = numFirst / numSecond;
                if (numSecond != 0){
                    return "Total Calculation : " + totalCaculation;
                }else {
                    return "Number is not valid";
                }
            default:
                return "Please enter the number !!!";
        }
    }
}
