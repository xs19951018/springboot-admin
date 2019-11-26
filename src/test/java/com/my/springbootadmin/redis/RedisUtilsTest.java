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

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
        //add
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

    @Test
    public void testHash(){
        //redis能够存储的数据结构:string | list(链表) | set(集合) | zset(sorted set-有序集合) | hash(哈希)

        //3. hash
        //put
        redisTemplate.opsForHash().put("hash", "name", "xiaoming");
        redisTemplate.opsForHash().put("hash", "age", "16");
        redisTemplate.opsForHash().put("hash", "sex", "男");
        System.out.println(redisTemplate.opsForHash().entries("hash"));
        Map<String, String> map = new HashMap<>();
        map.put("score", "100");
        map.put("skill", "跳舞");
        redisTemplate.opsForHash().putAll("hash", map);
        System.out.println(redisTemplate.opsForHash().entries("hash"));
        //haskey
        System.out.println(redisTemplate.opsForHash().hasKey("hash", "name"));
        //getkey
        System.out.println(redisTemplate.opsForHash().get("hash", "name"));
        //keys
        System.out.println(redisTemplate.opsForHash().keys("hash"));
        //size
        System.out.println(redisTemplate.opsForHash().size("hash"));
        //delete
        redisTemplate.opsForHash().delete("hash", "age");
        System.out.println(redisTemplate.opsForHash().entries("hash"));
    }

    @Test
    public void testSet(){
        //redis能够存储的数据结构:string | list(链表) | set(集合) | zset(sorted set-有序集合) | hash(哈希)

        //4. set
        //add
        redisTemplate.opsForSet().add("set", "aaa", "bbb","ccc");
        System.out.println(redisTemplate.opsForSet().members("set"));
        //remove
        redisTemplate.opsForSet().remove("set", "bbb");
        System.out.println(redisTemplate.opsForSet().members("set"));
        //size
        System.out.println(redisTemplate.opsForSet().size("set"));
        //move
        redisTemplate.opsForSet().move("set", "ccc", "set2");
        System.out.println(redisTemplate.opsForSet().members("set"));
        System.out.println(redisTemplate.opsForSet().members("set2"));

    }

    @Test
    public void testZSet(){
        //redis能够存储的数据结构:string | list(链表) | set(集合) | zset(sorted set-有序集合) | hash(哈希)

        //4. zset
        //add
        redisTemplate.opsForZSet().add("zset", "111", 3);
        redisTemplate.opsForZSet().add("zset", "222", 2);
        redisTemplate.opsForZSet().add("zset", "333", 1);
        System.out.println(redisTemplate.opsForZSet().rank("zset", "222"));
        System.out.println(redisTemplate.opsForZSet().range("zset", 0, -1));
        //remove
        redisTemplate.opsForZSet().remove("zset", "111");
        System.out.println(redisTemplate.opsForZSet().range("zset", 0, -1));
        //count
        System.out.println(redisTemplate.opsForZSet().count("zset", 0, -1));
        //score
        System.out.println(redisTemplate.opsForZSet().score("zset", "333"));

    }
}