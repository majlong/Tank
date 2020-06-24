package com.mjl.test.gc;

/**
 * @Auther: mjl
 * @Date: 2020/6/24 - 18:29
 * @Description: com.mjl.test.gc
 * @version: 1.0
 */
public class TestMain {
    public static void main(String[] args) {
       // Moveable mv = new Broom();
        //mv.go();
        //任意定制交通工具：继承Moveable
        //任意定制生产过程：XXXFactory creat() 返回值是moveable
        Moveable mv = new CarFactory().creat();// 工厂方法
        mv.go();
    }


}
