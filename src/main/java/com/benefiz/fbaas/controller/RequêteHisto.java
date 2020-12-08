package com.benefiz.fbaas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class RequêteHisto {

    private static ArrayList<String> logger = new ArrayList<String>(5000);

    public void log(final String query) {
        logger.add(query);
    }

    @GetMapping("fb/log")
    public ArrayList<String> getLogs() {
        return logger;
    }
}