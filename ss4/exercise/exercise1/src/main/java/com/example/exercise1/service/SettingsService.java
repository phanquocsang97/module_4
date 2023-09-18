package com.example.exercise1.service;

import com.example.exercise1.model.Settings;
import com.example.exercise1.repository.ISettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SettingsService implements ISettingsService {
    @Autowired
    private ISettingsRepository settingsRepository;

    @Override
    public Settings getSettings() {
        return settingsRepository.getSettings();
    }

    @Override
    public void update(Settings settings) {
        settingsRepository.update(settings);
    }
}
