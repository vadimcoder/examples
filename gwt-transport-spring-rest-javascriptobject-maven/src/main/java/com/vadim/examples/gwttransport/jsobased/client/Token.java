package com.vadim.examples.gwttransport.jsobased.client;

import com.google.gwt.core.client.JavaScriptObject;

public class Token extends JavaScriptObject {
    protected Token() {
    }

    public final native String getData1() /*-{
        return this["data1"];
    }-*/;

    public final native String getData2() /*-{
        return this["data2"];
    }-*/;
}
