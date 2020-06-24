package com.mjl.test.gc.abstractfactory;

import com.mjl.test.gc.CarFactory;
import com.mjl.test.gc.Moveable;

/**
 * @Auther: mjl
 * @Date: 2020/6/24 - 18:29
 * @Description: com.mjl.test.gc
 * @version: 1.0
 */
public class TestMain {
    public static void main(String[] args) {

//        Car c = new Car();
//        c.go();
//        AK47 ak47 = new AK47();
//        ak47.shoot();
//        Bread b = new Bread();
//        b.printName();
        //产品族--现代系列
        //怎么灵活扩建产品组,这样可以随意扩展，可以加一个火星工厂，这样族好扩展但是再加一个衣服等，横向不好扩展
        //但是工厂方法，产品维度好扩展，都有优缺点
        //所以springbean工厂帮我们解决这个问题
        //为什么用了抽象类，而没有接口呢？因为形容词用接口，名词用抽象类
        //
        AbstractFactory absfactory = new ModernFactory();
        Vehicle vehicle = absfactory.creatVehicle();
        vehicle.go();
        Food food = absfactory.creatFood();
        food.printName();
        Weapon weapon = absfactory.creatWeapon();
        weapon.shoot();
    }


}
