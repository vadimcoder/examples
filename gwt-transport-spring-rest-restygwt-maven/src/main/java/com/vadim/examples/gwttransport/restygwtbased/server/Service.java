package com.vadim.examples.gwttransport.restygwtbased.server;

import com.vadim.examples.gwttransport.restygwtbased.shared.SimpleDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Service {
    private final static Logger logger = LoggerFactory.getLogger(Service.class);

    @RequestMapping
    public /*thanks to jackson-jaxrs-json-provider*/ SimpleDTO  service(@RequestBody /*thanks to jackson-jaxrs-json-provider*/ SimpleDTO simpleDTO) {
        logger.info(simpleDTO.getData());

        SimpleDTO response = new SimpleDTO();
        response.setData("hello from server");

        return response;
    }
}
