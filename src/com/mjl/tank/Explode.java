package com.mjl.tank;

import com.mjl.ResourceMgr;

import java.awt.*;

/**
 * @Auther: mjl
 * @Date: 2020/6/22 - 18:30
 * @Description: 爆炸效果类
 * @version: 1.0
 */
public class Explode {
    public static final int WIDTH = ResourceMgr.explodes[0].getWidth();
    public static final int HEIGHT = ResourceMgr.explodes[0].getHeight();
    private int x, y;//坐标
    private boolean living = true;//子弹还在屏幕内,是否活着

    private TankFrame tf = null;
    private int step = 0;

    public Explode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
    }

    public void paint(Graphics g) {
        g.drawImage(ResourceMgr.explodes[step++], x, y, null);
        if (step >= ResourceMgr.explodes.length)
            step = 0;
    }

}
