package com.example.exercise1.repository;

import com.example.exercise1.model.Settings;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class SettingsRepository implements ISettingsRepository{
//    List<Settings> settingsList = new ArrayList<>();
    private Settings settings = new Settings("English",5,false,"Thor: King Asgard");
    @Override
    public Settings getSettings() {
        return settings;
    }

    @Override
    public void update(Settings newSettings) {
        settings = newSettings;
    }
}
