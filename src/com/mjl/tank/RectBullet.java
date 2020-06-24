package com.mjl.tank;

import com.mjl.tank.abstractfactory.BaseBullet;

import java.awt.*;

/**
 * @Auther: mjl
 * @Date: 2020/6/22 - 18:30
 * @Description: com.mjl
 * @version: 1.0
 */
public class RectBullet extends BaseBullet {
    private static final int SPEED = 10;//子弹速度
    public static final int WIDTH = ResourceMgr.bulletD.getWidth();
    public static final int HEIGHT = ResourceMgr.bulletD.getHeight();// 子弹大小
    private int x,y;//坐标
    private Dir dir;  //子弹方向
    private  boolean living = true;//子弹还在屏幕内,是否活着
    private TankFrame tf = null;
    private Group group = Group.BAD;
    Rectangle rectangle = new Rectangle();

    public RectBullet(int x, int y, Dir dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;
        rectangle.x = this.x;
        rectangle.y = this.y;
        rectangle.width = WIDTH;
        rectangle.height = HEIGHT;
        tf.bullets.add(this);//把自己加到bullets队列里面去
    }
    @Override
    public void paint(Graphics g) {
        if (!living) tf.bullets.remove(this);//子弹飞出屏幕，删除子弹
        /*switch (dir){
            case LEFT:
                g.drawImage(ResourceMgr.bulletL,x,y,null);
                break;
            case UP:
                g.drawImage(ResourceMgr.bulletU,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletD,x,y,null);
                break;
        }*/
        Color color = g.getColor();
        g.setColor(Color.YELLOW);
        g.fillRect(x,y,20,20);
        g.setColor(color);
        move();
    }
    private void move() {
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

        rectangle.x = this.x;
        rectangle.y = this.y;

        if (x<0 || y<0 || x>TankFrame.GAME_WIDTH || y>TankFrame.GAME_HEIGHT){
             living = false;
        }
    }
    //子弹和坦克碰撞检测
    public void collideWith(Tank tank) {
        if (this.group == tank.getGroup()) return;
        //TODO 用一个rect来记录子弹位置
        //Rectangle rect1 = new Rectangle(this.x,this.y,WIDTH,HEIGHT);
        //Rectangle rect2 = new Rectangle(tank.getX(),tank.getY() ,Tank.WIDTH,Tank.HEIGHT);
        if (rectangle.intersects(tank.rectangle)){
            tank.die();
            this.die();
            //tf.explodes.add(new Explode(tank.getX(),tank.getY() ,tf));
            tf.explodes.add(tf.gameFactory.CreatExplode(tank.getX(),tank.getY() ,tf));//改成抽象工厂生产

        }
    }

    private void die() {
        this.living = false;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
