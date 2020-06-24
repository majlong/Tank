package com.mjl.test.gc.abstractfactory;

/**
 * @Auther: mjl
 * @Date: 2020/6/24 - 19:26
 * @Description: com.mjl.test.gc.abstractfactory
 * 抽象工厂
 * @version: 1.0
 */
public abstract class AbstractFactory {
    abstract Food creatFood();
    abstract Vehicle creatVehicle();
    abstract Weapon creatWeapon();
}
