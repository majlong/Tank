package com.mjl.tank;

import com.mjl.tank.abstractfactory.*;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;


/**
 * @Auther: mjl
 * @Date: 2020/6/22 - 15:57
 * @Description: com.mjl
 * @version: 1.0
 */
public class TankFrame extends Frame {

    Tank tank = new Tank(200, 400, Dir.UP,Group.GOOD,this);
    //Bullet bullet = new Bullet(300, 300, Dir.UP);
    //List<Bullet> bullets = new ArrayList<Bullet>();
    List<Tank> tanks = new ArrayList<Tank>();
    //List<Explode> explodes = new ArrayList<>();//
    List<BaseBullet> bullets = new ArrayList<>();//替换成抽象工厂方式生产
    //List<BaseTank> tanks = new ArrayList<>();//替换成抽象工厂方式生产
    List<BaseExplode> explodes = new ArrayList<>();//替换成抽象工厂方式生产
    //GameFactory gameFactory = new DefaultFactory();//默认爆炸效果
    GameFactory gameFactory = new RectFactory();//方形爆炸效果

   // Explode e = new Explode(100,100,this);

    static final int GAME_WIDTH = 800, GAME_HEIGHT = 600;

    public TankFrame() {
        setSize(GAME_WIDTH, GAME_HEIGHT);
        setResizable(false);
        setTitle("tank war");
        setVisible(true);
        //键盘监听
        this.addKeyListener(new MykeyListener());
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    Image offScreenImage = null;

    //解决屏幕闪烁的问题，双缓冲，repaint会先调用update（）方法，先画到内存，内存的内容复制的显存
    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹数量："+bullets.size(),10,60);
        g.drawString("敌人数量："+tanks.size(),10,80);
        g.drawString("爆炸数量："+explodes.size(),10,100);
        g.setColor(c);
        tank.paint(g);
        for (int i=0;i<bullets.size();i++){
            bullets.get(i).paint(g);
        }
        for (int i=0;i<tanks.size();i++){
            tanks.get(i).paint(g);
        }
        for (int i=0;i<explodes.size();i++){
            explodes.get(i).paint(g);
        }

        //碰撞检测
        for (int i=0;i<bullets.size();i++){
            for (int j=0;j<tanks.size();j++){
                bullets.get(i).collideWith(tanks.get(j));
            }
        }
      //  e.paint(g);
    }

    class MykeyListener extends KeyAdapter {
        private boolean bL = false;
        private boolean bU = false;
        private boolean bR = false;
        private boolean bD = false;

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {

                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                default:
                    break;
            }

            setMainTankDir();
        }


        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {

                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
                case KeyEvent.VK_SPACE:
                    tank.fire();
                default:
                    break;
            }
            setMainTankDir();
        }

        private void setMainTankDir() {
            if (!bL && !bU && !bR && !bD) tank.setMoving(false);
            else {
                tank.setMoving(true);
                if (bL) tank.setDir(Dir.LEFT);
                if (bU) tank.setDir(Dir.UP);
                if (bR) tank.setDir(Dir.RIGHT);
                if (bD) tank.setDir(Dir.DOWN);
            }

        }
    }
}
