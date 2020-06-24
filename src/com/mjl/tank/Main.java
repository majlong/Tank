package com.mjl.tank;

public class Main {

    public static void main(String[] args) throws InterruptedException {
	 TankFrame tankFrame = new TankFrame();

	 	int initTankCount = Integer.parseInt(PropertyMgr.get("initTankCount")+"");

		//初始化敌方坦克
		for(int i= 0;i<initTankCount ;i++){
			tankFrame.tanks.add(new Tank(50+i*60,100,Dir.DOWN,Group.BAD,tankFrame));


		}


	 while (true){
	     Thread.sleep(50);
	     tankFrame.repaint();
     }

    }
}
