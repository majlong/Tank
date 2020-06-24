package com.mjl.tank;

import java.io.IOException;
import java.util.Properties;

/**
 * @Auther: mjl
 * @Date: 2020/6/23 - 16:46
 * @Description: com.mjl.tank
 * @version: 1.0
 */
public class PropertyMgr {
    static Properties props = new Properties();
    static {
        try {
            props.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private PropertyMgr(){}
    public static Object get(String key){
        if (props ==null) return null;
        return props.get(key);
    }

    public static void main(String[] args) {
        System.out.println(PropertyMgr.get("initTankCount"));
        ;
    }
}
