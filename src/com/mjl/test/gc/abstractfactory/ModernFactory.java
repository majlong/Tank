package com.mjl.test.gc.abstractfactory;

/**
 * @Auther: mjl
 * @Date: 2020/6/24 - 19:32
 * @Description: com.mjl.test.gc.abstractfactory 现代工厂
 * @version: 1.0
 */
public class ModernFactory extends AbstractFactory{
    @Override
    Food creatFood() {
        return new Bread();
    }

    @Override
    Vehicle creatVehicle() {
        return new Car();
    }

    @Override
    Weapon creatWeapon() {
        return new AK47();
    }
}
