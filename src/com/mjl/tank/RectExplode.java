package com.mjl.tank;

import com.mjl.tank.Audio;
import com.mjl.tank.ResourceMgr;
import com.mjl.tank.TankFrame;
import com.mjl.tank.abstractfactory.BaseExplode;

import java.awt.*;

/**
 * @Auther: mjl
 * @Date: 2020/6/24 - 22:04
 * @Description: com.mjl.tank.abstractfactory
 * @version: 1.0
 */
public class RectExplode extends BaseExplode {
    public static final int WIDTH = ResourceMgr.explodes[0].getWidth();
    public static final int HEIGHT = ResourceMgr.explodes[0].getHeight();
    private int x, y;//坐标
    private boolean living = true;//子弹还在屏幕内,是否活着

    private TankFrame tf = null;
    private int step = 0;

    public RectExplode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
        new Thread(() -> new Audio("audio/explode.wav").play()).start();
    }

    @Override
    public void paint(Graphics g) {
        //g.drawImage(ResourceMgr.explodes[step++], x, y, null);
//        if (step >= ResourceMgr.explodes.length)
//            tf.explodes.remove(this);
        Color color = g.getColor();
        g.setColor(Color.RED);
        g.fillRect(x, y, 10 * step, 10 * step);
        step++;
        if (step >= 10) {
            tf.explodes.remove(this);
        }
        g.setColor(color);
    }

}
