package com.mjl;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Auther: mjl
 * @Date: 2020/6/22 - 15:57
 * @Description: com.mjl
 * @version: 1.0
 */
public class TankFrame extends Frame {

    int x = 200, y = 200;

    public TankFrame() {
        setSize(800, 600);
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

    @Override
    public void paint(Graphics g) {
      //  System.out.println("paint");
        g.fillRect(x, y, 50, 50);
        //x += 10;
        //y += 10;

    }

    class MykeyListener extends KeyAdapter {
        private boolean bL = false;
        private boolean bU = false;
        private boolean bR = false;
        private boolean bD = false;
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key){

                case KeyEvent.VK_LEFT:
                    bL=true;
                    break;
                case KeyEvent.VK_UP:
                    bU=true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR=true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD=true;
                    break;
                default:
                    break;
            }
/*            System.out.println("key pressed");
            x += 10;
            repaint();*/
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key){

                case KeyEvent.VK_LEFT:
                    bL=false;
                    break;
                case KeyEvent.VK_UP:
                    bU=false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR=false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD=false;
                    break;
                default:
                    break;
            }
        }
    }
}
