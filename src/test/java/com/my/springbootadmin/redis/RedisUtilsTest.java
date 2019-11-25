package com.my.springbootadmin.redis;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.junit.Assert.*;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisUtilsTest {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    public void test1(){
        //redis能够存储的数据结构:string | list(链表) | set(集合) | zset(sorted set-有序集合) | hash(哈希)

        //1.string
        //设值set
        redisTemplate.opsForValue().set("name", "nihaoa");
        System.out.println(redisTemplate.opsForValue().get("name"));
        //追加append
        redisTemplate.opsForValue().set("test","Hello");
        System.out.println(redisTemplate.opsForValue().get("test"));
        System.out.println(redisTemplate.opsForValue().size("test"));
        redisTemplate.opsForValue().append("test","world");
        System.out.println(redisTemplate.opsForValue().get("test"));
        //长度size
        System.out.println(redisTemplate.opsForValue().size("test"));


    }

    @Test
    public void test2(){
        //redis能够存储的数据结构:string | list(链表) | set(集合) | zset(sorted set-有序集合) | hash(哈希)

        //2.list
        redisTemplate.delete("list");
        redisTemplate.opsForList().leftPush("list", "111");
        redisTemplate.opsForList().leftPush("list", "222");
        redisTemplate.opsForList().leftPush("list", "333");
        System.out.println("list:"+redisTemplate.opsForList().range("list", 0, -1));
        System.out.println("size:"+redisTemplate.opsForList().size("list"));
        //set
        redisTemplate.opsForList().set("list", 1, "apple");
        System.out.println("list:"+redisTemplate.opsForList().range("list", 0, -1));
        //remove
        redisTemplate.opsForList().remove("list", 0, "apple");
        System.out.println("list:"+redisTemplate.opsForList().range("list", 0, -1));
        //index
        String value = redisTemplate.opsForList().index("list", 0);
        System.out.println("index:"+value);

    }
}