package com.appmonster.appclient1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class AppConfigController {

    @Autowired
    Environment env;

    @Value("${db.host: hostname}")
    String host;

    @GetMapping("/getDbProp")
    public String getProp() {
        return "DB host " + host + " & password  " + env.getProperty("db.password");
    }
}
