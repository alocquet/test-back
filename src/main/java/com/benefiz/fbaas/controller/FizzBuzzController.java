package com.benefiz.fbaas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class FizzBuzzController {

    private RequeteHisto requêteHisto = new RequeteHisto();

    @GetMapping(value = {"fb/{from}", "fb/{from}/{to}"})
    public String fizzbuzz(final @RequestParam String from, final @RequestParam Optional<String> to) {
        requêteHisto.getLogs().add(from);

        return (Integer.valueOf(from) % 5 == 0 && Integer.valueOf(from) % 3 == 0) ? "FizzBuzz" : (Integer.valueOf(from) % 5 == 0 ? "Buzz" : (Integer.valueOf(from) % 3 == 0 ? "Fizz" : from));

    }

}

