package com.my.springbootadmin.utils;

import java.util.UUID;

/**
 * 获取32位uuid
 */
public class UuidUtils {

    public static String getUuid(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
