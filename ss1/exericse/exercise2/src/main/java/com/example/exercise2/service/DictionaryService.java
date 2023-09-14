package com.example.exercise2.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class DictionaryService {
    public String Translate(String english){
        Map<String,String> mapTranslate = new HashMap<>();
        mapTranslate.put("flowers","hoa");
        mapTranslate.put("house","nhà");
        mapTranslate.put("table","bàn");
        for (Map.Entry<String, String> entry :mapTranslate.entrySet()) {
            if (entry.getKey().toUpperCase().equals(english.toUpperCase())){
                return entry.getValue();
            }
        }
        return null;
    }
}
