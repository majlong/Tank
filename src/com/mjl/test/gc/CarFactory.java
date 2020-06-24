package com.mjl.test.gc;

/**
 * @Auther: mjl
 * @Date: 2020/6/24 - 18:43
 * @Description: com.mjl.test.gc  工厂方法
 * @version: 1.0
 */
public class CarFactory {
    public Moveable creat(){
        System.out.println("a car was created!");
        return new Car();
    }
}
