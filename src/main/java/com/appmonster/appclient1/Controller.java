package com.appmonster.appclient1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class Controller {

    @Value("${welcome.greeting: default value}")
    private String greeting;


    @GetMapping("/greeting")
    public String getProp() {
        return "Greeting " + greeting + ".";
    }
}
