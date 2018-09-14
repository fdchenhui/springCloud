package com.ch.uc.context;

import com.ch.uc.constant.CommonConstant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by Administrator on 2018/9/7.
 */
public class BaseContextHandler {

    public static final ThreadLocal<Map<String,Object>> threadLocal = new ThreadLocal<Map<String, Object>>();
    public static void set(String key,String value){
        Map<String, Object> map = threadLocal.get();
        if (map == null){
            map = new HashMap<String, Object>();
            threadLocal.set(map);
        }
        map.put(key,value);
    }
    public static Object get(String key){
        Map<String, Object> map = threadLocal.get();
        if (map == null){
            map = new HashMap<String, Object>();
            threadLocal.set(map);
        }
        return map.get(key);
    }
    public static void init(){
        Map<String, Object> map = threadLocal.get();
        if (map == null){
            map = new HashMap<String, Object>();
            threadLocal.set(map);
        }
    }
    public static void remove(){
        threadLocal.remove();
    }

    public static String getUserId(){
        Object value = get(CommonConstant.CONTEXT_KEY_USER_ID);
        return  returnObjectValue(value);
    }

    public static void setUserId(String userId){
        set(CommonConstant.CONTEXT_KEY_USER_ID,userId);
    }

    public static String getUserName(){
        Object value = get(CommonConstant.CONTEXT_KEY_USER_NAME);
        return  returnObjectValue(value);
    }

    public static void setUserName(String username){
        set(CommonConstant.CONTEXT_KEY_USER_NAME,username);
    }

    private static String returnObjectValue(Object value) {
        return value == null? null:value.toString();
    }


    @RunWith(MockitoJUnitRunner.class)
    public static class UnitTest{

        private  Logger logger = LoggerFactory.getLogger(UnitTest.class);
        @Test
        public void testSetContextVaiable() throws InterruptedException {
            BaseContextHandler.set("test", "main");
            new Thread(() -> {
                BaseContextHandler.set("test", "moo");
                try {
                    Thread.currentThread().sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                assertEquals(BaseContextHandler.get("test"), "moo");
                logger.info("thread one done!");
            }).start();
            new Thread(() -> {
                BaseContextHandler.set("test", "moo2");
                assertEquals(BaseContextHandler.get("test"), "moo2");
                logger.info("thread two done!");
            }).start();
            Thread.currentThread().sleep(5000);
            assertEquals(BaseContextHandler.get("test"), "main");
            logger.info("thread main done!");
        }

        @Test
        public void testSetUserInfo(){
            BaseContextHandler.setUserId("test");
            assertEquals(BaseContextHandler.getUserId(), "test");
            BaseContextHandler.setUserName("test2");
            assertEquals(BaseContextHandler.getUserName(), "test2");
        }

    }
}
