package com.sg.example.services;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class RoosterService {
	
	private final Logger logger = LoggerFactory.getLogger(RoosterService.class);

	private Map<String, String> hashMap;

    public String findByNativeBySound(String language) {
    	logger.info("In side service layer");
    	String result = hashMap.entrySet().stream()
                .filter(map -> language.equals(map.getKey()))
                .map(map -> map.getValue())
                .collect(Collectors.joining());
        return result;

    }

    // Init some users for testing
    @PostConstruct
    private void iniData() {
    	hashMap = new HashMap<>();
    	hashMap.put("Danish", "kykyliky");
    	hashMap.put("Dutch", "kukeleku");
    	hashMap.put("Finnish", "kukko kiekuu");
    	hashMap.put("French", "cocorico");
    	hashMap.put("German", "kikeriki");
    	hashMap.put("Greek", "kikiriki");
    	hashMap.put("Hebrew", "coo-koo-ri-koo");
    	hashMap.put("Hungarian", "kukuriku");
    	hashMap.put("Italian", "chicchirichi");
    	hashMap.put("Japanese", "ko-ke-kok-ko-o");
    	hashMap.put("Portuguese", "cucurucu");
    	hashMap.put("Russian", "kukareku");
    	hashMap.put("Swedish", "kuckeliku");
    	hashMap.put("Turkish", "kuk-kurri-kuuu");
    	hashMap.put("Urdu", "kuklooku");
    	hashMap.put("Tamil", "kocoraco");

    }

}
