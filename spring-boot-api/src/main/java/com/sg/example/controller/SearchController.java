package com.sg.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sg.example.model.Rooster;
import com.sg.example.services.RoosterService;

@RestController
public class SearchController {
	
	private final Logger logger = LoggerFactory.getLogger(SearchController.class);

    RoosterService roosterService;

    @Autowired
    public void setRoosterService(RoosterService roosterService) {
        this.roosterService = roosterService;
    }
   
 
    
    @PostMapping("/api/search")
    public Rooster getSearchResultViaAjax(@RequestBody String language) {
    	Rooster rooster=new Rooster();	
    	logger.info("In side post request");
    	String result=roosterService.findByNativeBySound(language);
    	logger.info("Result from post request"+result);
    	rooster.setNativelang(language);
    	rooster.setSounds(result);
        return rooster;

    }

}
