package com.example.exercise2.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService{
    double total = 0;
    @Override
    public double calculate(double numFirst, double numSecond, String input) {
        switch (input){
            case "Addition(+)":
                total = numFirst + numSecond;
                break;
            case "Subtraction(-)":
                total = numFirst - numSecond;
                break;
            case "Multiplication(*)":
                total = numFirst * numSecond;
                break;
            case "Division(/)":
                total = numFirst / numSecond;
                break;
        }
        return total;
    }
}
