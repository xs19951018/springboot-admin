package com.my.springbootadmin.mail;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class HtmlMessageTest {

    @Autowired
    private FreeMarkerConfigurer configurer;

    @Test
    public void run() throws IOException, TemplateException {
        //根据模板创建邮件内容
        Map<String, Object> map = new HashMap<>();
        map.put("name", "xiaoming");

        Template template = configurer.getConfiguration().getTemplate("freemarker\\mail\\ceshi.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, map);

        System.out.println(html);
    }
}