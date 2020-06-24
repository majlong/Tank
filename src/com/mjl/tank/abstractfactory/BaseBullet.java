package com.mjl.tank.abstractfactory;

import com.mjl.tank.Tank;

import java.awt.*;

/**
 * @Auther: mjl
 * @Date: 2020/6/24 - 21:26
 * @Description: com.mjl.tank.abstractfactory
 * @version: 1.0
 */
public abstract class BaseBullet {
    public abstract void paint(Graphics g);

    public abstract void collideWith(Tank tank);
}
