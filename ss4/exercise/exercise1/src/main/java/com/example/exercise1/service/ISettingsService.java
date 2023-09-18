package com.example.exercise1.service;

import com.example.exercise1.model.Settings;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ISettingsService {
    Settings getSettings();
    void update(Settings settings);
}
