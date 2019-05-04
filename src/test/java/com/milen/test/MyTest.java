package com.milen.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyTest {

    public static void main(String[] args) {
        String uri = "goomall/admin/shop/review";
        boolean isExisted = uri.matches("shop");
        System.out.println(isExisted);
    }
}
