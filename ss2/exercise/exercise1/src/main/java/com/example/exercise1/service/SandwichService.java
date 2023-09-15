package com.example.exercise1.service;

import org.springframework.stereotype.Service;

@Service
public class SandwichService implements ISandwichSerivce{
    public String[] spices(String[] condiment) {
        String[] spices = new String[condiment.length];
        for (int i = 0; i < condiment.length; i++) {
            spices[i] = condiment[i];
        }
        return spices;
    }
}
