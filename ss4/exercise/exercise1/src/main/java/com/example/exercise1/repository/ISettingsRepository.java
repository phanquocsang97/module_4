package com.example.exercise1.repository;

import com.example.exercise1.model.Settings;

import java.util.List;

public interface ISettingsRepository {
    Settings getSettings();
    void update(Settings settings);
}
