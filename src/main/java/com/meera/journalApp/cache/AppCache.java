package com.meera.journalApp.cache;

import com.meera.journalApp.entity.JournalConfig;
import com.meera.journalApp.repository.JournalConfigRepo;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AppCache {

    public enum keys {
        WEATHER_API;
    }

    @Autowired
    private JournalConfigRepo journalConfigRepo;

    public Map<String, String> appCache;

    @PostConstruct
    public void init() {
        appCache = new HashMap<>();
        List<JournalConfig> all = journalConfigRepo.findAll();
        for(JournalConfig x : all) {
            appCache.put(x.getKey(), x.getValue());
        }
    }
}
