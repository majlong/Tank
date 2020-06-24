package com.mjl.test.gc;

/**
 * @Auther: mjl
 * @Date: 2020/6/24 - 18:37
 * @Description: 简单工厂，扩展性并不好
 * @version: 1.0
 */
public class SimpleVehicleFactory {
    public Car creatCar(){
        //前后可以加一些权限控制
        return new Car() ;
    }
    public Broom creatBroom(){
        //前后可以加一些权限控制
        return new Broom() ;
    }
}
