package com.benefiz.fbaas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class FizzBuzzController {

    private RequêteHisto requêteHisto = new RequêteHisto();

    @GetMapping(value = {"fb/{from}", "fb/{from}/{to}"})
    public String fizzbuzz(final @PathVariable String from, final @PathVariable Optional<String> to) {
        requêteHisto.getLogs().add(from);

        if (Integer.valueOf(from) % 15 == 0)
            return "FizzBuzz";
        else if (Integer.valueOf(from) % 5 == 0)
            return "Buzz";
        else if (Integer.valueOf(from) % 3 == 0)
            return "Fizz";
        else
            return from;
    }

}

