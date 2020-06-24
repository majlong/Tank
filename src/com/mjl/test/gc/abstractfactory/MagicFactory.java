package com.mjl.test.gc.abstractfactory;

/**
 * @Auther: mjl
 * @Date: 2020/6/24 - 19:33
 * @Description: com.mjl.test.gc.abstractfactory 魔法工厂
 * @version: 1.0
 */
public class MagicFactory extends AbstractFactory{
    @Override
    Food creatFood() {
        return new MushRoom();
    }

    @Override
    Vehicle creatVehicle() {
        return new Broom();
    }

    @Override
    Weapon creatWeapon() {
        return new MagicStick();
    }
}
