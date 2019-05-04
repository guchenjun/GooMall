package com.milen.pojo.vo;


import java.util.HashMap;

public class R extends HashMap<String, Object>{

    public static R error(int code, String msg) {
        R r = new R();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static R error(int code, String msg, String data) {
        R r = new R();
        r.put("code", code);
        r.put("msg", msg);
        r.put("data", data);
        return r;
    }

    public static R ok(int code, String msg) {
        R r = new R();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static R ok(int code, String msg, String data) {
        R r = new R();
        r.put("code", code);
        r.put("msg", msg);
        r.put("data", data);
        return r;
    }
}
