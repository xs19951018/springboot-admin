package com.my.springbootadmin.test;

import java.util.Date;

public class TestOther {

    public static void main(String[] args) {
        String str = "1111";
        //test2();

        test3(str);
        System.out.println(str);
    }

    static void test1() {
        String str = "设备LAN口 GigabitEthernet 0/0 状态为up";
        str = str.replaceAll("Down|down", "").replaceAll("Up|up", "")
                .replaceAll("[^(A-Za-z0-9)]", "");
        System.out.println(str);
    }

    static void test2() {
        Date date = new Date();
        System.out.println(date);
    }

    static void test3(String str) {
        str = "123";
    }
}
