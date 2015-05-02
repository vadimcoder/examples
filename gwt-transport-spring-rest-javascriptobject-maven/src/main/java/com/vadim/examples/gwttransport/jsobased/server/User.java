package com.vadim.examples.gwttransport.jsobased.server;

import java.util.List;
import java.util.Map;

public class User {
    private String username;
    private Map<String, Object> permissions;
    private List<String> listOfSomething;
    private Token token;

    public User() {
    }

    public User(String username, Map<String, Object> permissions) {
        this.username = username;
        this.permissions = permissions;
    }

    public String getUsername() {
        return username;
    };

    public Map<String, Object> getPermissions() {
        return permissions;
    }

    public List<String> getData() {
        return listOfSomething;
    }

    public void setData(List<String> listOfSomething) {
        this.listOfSomething = listOfSomething;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }
}
