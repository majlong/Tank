package com.mjl.tank;

public class Main {

    public static void main(String[] args) throws InterruptedException {
	 TankFrame tankFrame = new TankFrame();
//初始化坦克
		for(int i= 0;i<5 ;i++){
			tankFrame.tanks.add(new Tank(50+i*60,200,Dir.DOWN,tankFrame));


		}


	 while (true){
	     Thread.sleep(50);
	     tankFrame.repaint();
     }

    }
}
