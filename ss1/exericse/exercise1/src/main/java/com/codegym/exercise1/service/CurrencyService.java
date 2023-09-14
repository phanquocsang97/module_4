package com.codegym.exercise1.service;

import org.springframework.stereotype.Service;
@Service
public class CurrencyService {
   public double CurrencyConversion(int usd){
       return usd * 23500;
   }
}
