package com.pabs.lms.app.controller;


import com.pabs.lms.app.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pabs.lms.app.beans.LimitsConfiguration;

@RestController
public class LimitsConfigurationController {

    @Autowired
    private Configuration configuration;

    @GetMapping("/limits")
    public LimitsConfiguration getLimitsConfigurtionsFromConfigServer(){

        // deliberately hard coding for w=now
        //return new LimitsConfiguration(1000,1);

        return new LimitsConfiguration(configuration.getMaximum(),configuration.getMinimum());

    }
}
