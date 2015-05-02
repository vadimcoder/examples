package com.vadim.examples.gwttransport.jsobased.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import org.fusesource.restygwt.client.JsonCallback;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.Resource;

import java.util.logging.Logger;

public class MyEntryPoint implements EntryPoint {
    private static final Logger logger = Logger.getLogger(MyEntryPoint.class.getName());

    @Override
    public void onModuleLoad() {


        User user = JavaScriptObject.createObject().cast();
        user.setData(new String[]{"data from client 1", "data from client 2"});

        Resource resource = new Resource("/springwebmvc/getUser") ;
        resource.post().json(new JSONObject(user)).send(new JsonCallback() {
            @Override
            public void onFailure(Method method, Throwable exception) {

            }

            @Override
            public void onSuccess(Method method, JSONValue response) {
                User user = response.isObject().getJavaScriptObject().cast();
                logger.info(user.getUsername());
                logger.info(response.isObject().get("permissions").isObject().get("key1").isString().toString());
                logger.info(user.getPermissions().get("key1").isString().toString());
                logger.info(user.getToken().getData1());
                logger.info(String.valueOf(user.getToken().getData2() == null)); // true
            }
        });
    }
}
