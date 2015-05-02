package com.vadim.examples.gwttransport.restygwtbased.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.json.client.JSONValue;
import com.vadim.examples.gwttransport.restygwtbased.shared.SimpleDTO;
import org.fusesource.restygwt.client.JsonCallback;
import org.fusesource.restygwt.client.JsonEncoderDecoder;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.Resource;

import java.util.logging.Logger;

public class MyEntryPoint implements EntryPoint {
    private static final Logger logger = Logger.getLogger(MyEntryPoint.class.getName());

    static interface SimpleDTODecoder extends JsonEncoderDecoder<SimpleDTO> {}
    private static final SimpleDTODecoder ENCODER_DECODER = GWT.create(SimpleDTODecoder.class);

    @Override
    public void onModuleLoad() {
        SimpleDTO simpleDTO = new SimpleDTO();
        simpleDTO.setData("hello from client");

        JSONValue encodedSimpleDTO = ENCODER_DECODER.encode(simpleDTO);

        Resource resource = new Resource("/springwebmvc/service");
        resource.post().json(encodedSimpleDTO).send(new JsonCallback() {
            @Override
            public void onFailure(Method method, Throwable exception) {

            }

            @Override
            public void onSuccess(Method method, JSONValue response) {
                SimpleDTO simpleDTO = ENCODER_DECODER.decode(response);
                logger.info(simpleDTO.getData());
            }
        });
    }
}
