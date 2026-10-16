package br.com.erudio.controllers;

import br.com.erudio.model.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreentingController {
    private final AtomicLong count= new AtomicLong();
    private static final String template= "Hello, %s!";
    @RequestMapping("/greeting")
    public Greeting greeting (
            @RequestParam(value = "name", defaultValue = "world!")
            String name){

        return new Greeting(count.incrementAndGet(), String.format(template, name));
    }
}
