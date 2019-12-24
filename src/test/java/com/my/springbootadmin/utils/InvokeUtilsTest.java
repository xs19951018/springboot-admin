package com.my.springbootadmin.utils;

import com.my.springbootadmin.service.CoreTimerService;
import com.my.springbootadmin.service.impl.CoreTimerServiceImp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvokeUtilsTest {

    @Test
    public void test() {
        String serviceName = "coreTimerService";
        String methodName = "run";
        String classPath = "com.my.springbootadmin.service.impl."+CamelUtils.strTransferCamelName(serviceName,",")+"Imp";

        Class clazz = null;
        try {
            clazz = Class.forName(classPath);
            Method method = clazz.getMethod(methodName);
            method.invoke(clazz.newInstance());
            System.out.println(clazz);
            System.out.println(method);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }
}