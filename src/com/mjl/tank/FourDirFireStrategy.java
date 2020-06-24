package com.mjl.tank;

/**
 * @Auther: mjl
 * @Date: 2020/6/24 - 13:34
 * @Description: 主站坦克4个方向开火
 * @version: 1.0
 */
public class FourDirFireStrategy implements FireStrategy {
    @Override
    public void fire(Tank t) {
        int bX =    t.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int bY =    t.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
        Dir[] dirs = Dir.values();
        for (Dir dir : dirs){
             //new Bullet(bX,bY,dir,t.group,t.tf);
             t.tf.gameFactory.CreatBullet(bX,bY,dir,t.group,t.tf);
        }
        if(t.group == Group.GOOD) new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
    }
}
