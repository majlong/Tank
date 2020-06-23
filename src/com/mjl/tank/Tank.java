package com.mjl.tank;

import com.mjl.ResourceMgr;

import java.awt.*;
import java.lang.annotation.Retention;
import java.util.Random;

/**
 * @Auther: mjl
 * @Date: 2020/6/22 - 17:51
 * @Description: com.mjl
 * @version: 1.0
 */
public class Tank {
    private int x,y;
    private Dir dir = Dir.UP ;//方向
    private static final int SPEED = 2;
    public static final int WIDTH = ResourceMgr.goodTankD.getWidth();
    public static final int HEIGHT = ResourceMgr.goodTankD.getHeight();// 坦克大小
    private boolean moving = true;//tank是移动还是静止

    private Random random = new Random();

    private boolean living = true;//tank死活
    private TankFrame tf;
    private Group group = Group.BAD;

    Rectangle rectangle = new Rectangle();

    public Tank(int x, int y, Dir dir,Group group,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;
        rectangle.x = this.x;
        rectangle.y = this.y;
        rectangle.width = WIDTH;
        rectangle.height = HEIGHT;
    }

    public void paint(Graphics g) {
        if (!living) tf.tanks.remove(this);
        switch (dir){
            case LEFT:
                g.drawImage(this.group == Group.GOOD? ResourceMgr.goodTankL : ResourceMgr.badTankL,x,y,null);
                break;
            case UP:
                g.drawImage(this.group == Group.GOOD? ResourceMgr.goodTankU : ResourceMgr.badTankU,x,y,null);
                break;
            case RIGHT:
                g.drawImage(this.group == Group.GOOD? ResourceMgr.goodTankR : ResourceMgr.badTankR,x,y,null);
                break;
            case DOWN:
                g.drawImage(this.group == Group.GOOD? ResourceMgr.goodTankD : ResourceMgr.badTankD,x,y,null);
                break;
        }
       move();
    }

    private void move() {
        if (!moving) return;
        switch (dir){
            case LEFT:
                x-=SPEED;
                break;
            case UP:
                y-=SPEED;
                break;
            case RIGHT:
                x+=SPEED;
                break;
            case DOWN:
                y+=SPEED;
                break;
            default:
                break;
        }

         if (this.group == Group.BAD && random.nextInt(100) > 95) this.fire();
         if (this.group == Group.BAD && random.nextInt(100) > 95)
         randomDir();
         boundsCheck();
        rectangle.x = this.x;
        rectangle.y = this.y;
    }

    /**
     * 边界检测
     */
    private void boundsCheck() {
        if (this.x <0) x=0;
        if (this.y<30) y=30;
        if (this.x > TankFrame.GAME_WIDTH-Tank.WIDTH) x = TankFrame.GAME_WIDTH-Tank.WIDTH;
        if (this.y > TankFrame.GAME_HEIGHT-Tank.HEIGHT) y = TankFrame.GAME_HEIGHT-Tank.HEIGHT;
    }

    /**
     * 坦克随机方向
     */
    private void randomDir() {

        this.dir = dir.values()[random.nextInt(4)];

    }

    public void fire() {
        int bX =    this.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int bY =    this.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
        tf.bullets.add( new Bullet(bX,bY,this.dir,this.group,this.tf));
    }

    public void die() {
        this.living = false;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public static int getSPEED() {
        return SPEED;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }


}
