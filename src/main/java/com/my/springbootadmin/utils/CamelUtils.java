package com.my.springbootadmin.utils;

import org.springframework.util.StringUtils;

/**
 * 字符串转驼峰命名
 */
public class CamelUtils {

    /**
     * 驼峰命名 CORE_TIMER -> coreTimeer
     * @param str 字符串
     * @param sep 分隔符
     * @return
     */
    public static String strTransferCamelName(String str, CharSequence sep){
        //检查字符串
        if(StringUtils.isEmpty(str)){
            return "";
        }else if(!str.contains(sep)){
            //不包含字符，则默认为就一个单词
            return str.substring(0,1).toUpperCase()+str.substring(1);
        }

        StringBuffer sb = new StringBuffer();
        String[] camels = str.split((String) sep);
        String temp = null;

        for(int i=0;i<camels.length;i++){
            temp = camels[i].toLowerCase();
            sb.append(temp.substring(0,1).toUpperCase()+temp.substring(1));
        }
        return sb.toString();
    }

    /**
     * 驼峰命名 CORE_TIMER -> coreTimeer
     * @param str 字符串
     * @param sep 分隔符
     * @param index 开始索引
     * @return
     */
    public static String strTransferCamelName(String str, CharSequence sep, int index){
        //检查字符串
        if(StringUtils.isEmpty(str)){
            return "";
        }else if(!str.contains(sep)){
            //不包含字符，则默认为就一个单词
            return str.substring(0,1).toUpperCase()+str.substring(1);
        }

        StringBuffer sb = new StringBuffer();
        String[] camels = str.split((String) sep);
        String temp = null;

        for(int i=0;i<camels.length;i++){
            temp = camels[i].toLowerCase();
            if(i>=index){
                sb.append(temp.substring(0,1).toUpperCase()+temp.substring(1));
            }else{
                sb.append(temp);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        //uuids ，fieldname，value
        String tb = "CORE_ACCOUNT";
        String field = "CA_USER_NAME";

        Class clas = Class.forName("com.my.springbootadmin.model.CoreTimer");
        Object o = clas.newInstance();
        InvokeUtils.invokeSet(o,"ctName", "测试");

        System.out.println(o.toString());
    }
}
