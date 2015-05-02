package com.vadim.examples.gwttransport.jsobased.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.json.client.JSONObject;

public class User extends JavaScriptObject {
    protected User() {
    }

    public final native String getUsername() /*-{
        return this["username"];
    }-*/;

    public final JSONObject getPermissions() {
        return new JSONObject(getPermissionsJso());
    }

    private native JavaScriptObject getPermissionsJso() /*-{
        return this["permissions"];
    }-*/;

    public final native void setData(String[] data) /*-{
        this["data"] = data;
    }-*/;

    public final native Token getToken() /*-{
        return this["token"];
    }-*/;
}
