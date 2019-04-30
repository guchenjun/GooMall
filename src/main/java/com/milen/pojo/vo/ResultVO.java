package com.milen.pojo.vo;


import java.util.HashMap;

public class ResultVO extends HashMap<String, Object>{

    public static ResultVO error(int code, String msg) {
        ResultVO r = new ResultVO();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static ResultVO error(int code, String msg, String data) {
        ResultVO r = new ResultVO();
        r.put("code", code);
        r.put("msg", msg);
        r.put("data", data);
        return r;
    }

    public static ResultVO ok(int code, String msg) {
        ResultVO r = new ResultVO();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static ResultVO ok(int code, String msg, String data) {
        ResultVO r = new ResultVO();
        r.put("code", code);
        r.put("msg", msg);
        r.put("data", data);
        return r;
    }
}
