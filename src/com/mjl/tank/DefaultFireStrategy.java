package com.mjl.tank;

/**
 * @Auther: mjl
 * @Date: 2020/6/24 - 13:34
 * @Description: com.mjl.tank
 * @version: 1.0
 */
public class DefaultFireStrategy implements FireStrategy {
    @Override
    public void fire(Tank t) {
        int bX =    t.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int bY =    t.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
        new Bullet(bX,bY,t.dir,t.group,t.tf);
        if(t.group == Group.GOOD) new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
    }
}
