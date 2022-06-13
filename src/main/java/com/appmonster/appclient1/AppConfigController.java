package com.appmonster.appclient1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class AppConfigController {

    @Value("${spring.datasource.url: default url}")
    public String url;

    @Value("${spring.datasource.username: default username}")
    public String username;

    @Value("${spring.datasource.password: default password}")
    public String password;

    @ResponseBody
    @GetMapping("/dbproperties")
    public DBConfigProperties getProp() {
        return new DBConfigProperties(url, username, password);
    }
}
