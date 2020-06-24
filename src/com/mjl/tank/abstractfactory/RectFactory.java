package com.mjl.tank.abstractfactory;

import com.mjl.tank.*;

/**
 * @Auther: mjl
 * @Date: 2020/6/24 - 22:06
 * @Description: com.mjl.tank.abstractfactory
 * @version: 1.0
 */
public class RectFactory extends GameFactory {
    @Override
    public BaseTank CreatTank(int x, int y, Dir dir, Group group, TankFrame tf) {
        return new Tank(x,y,dir,group,tf);
    }

    @Override
    public BaseBullet CreatBullet(int x, int y, Dir dir, Group group, TankFrame tf) {
        return new RectBullet(x,y,dir,group,tf);
    }

    @Override
    public BaseExplode CreatExplode(int x, int y, TankFrame tf) {
        return new RectExplode(x,y,tf);
    }
}
