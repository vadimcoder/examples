package com.vadim.examples.gwttransport.jsobased.server;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import static java.util.Arrays.asList;

@RestController
public class Service {
    private static final Logger logger = Logger.getLogger(Service.class.getName());

    @RequestMapping
    public User getUser(@RequestBody User userRequest) {
        logger.info("Data from client: " + userRequest.getData().get(0));

        Map<String, Object> permissions = new HashMap<>();
        permissions.put("key1", "value1");
        permissions.put("key2", "value2");

        User userResponse = new User("data from server", permissions);
        Token token = new Token();
        token.setData1("token from server");
        userResponse.setToken(token);

        return userResponse;
    }
}
