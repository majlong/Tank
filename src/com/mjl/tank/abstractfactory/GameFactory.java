package com.mjl.tank.abstractfactory;

import com.mjl.tank.Dir;
import com.mjl.tank.Group;
import com.mjl.tank.TankFrame;

/**
 * @Auther: mjl
 * @Date: 2020/6/24 - 21:19
 * @Description: com.mjl.tank.abstractfactory
 * @version: 1.0
 */
public abstract  class GameFactory {
    public abstract BaseTank CreatTank(int x, int y, Dir dir, Group group, TankFrame tf);
    public abstract BaseBullet CreatBullet(int x, int y, Dir dir, Group group, TankFrame tf);
    public abstract BaseExplode CreatExplode(int x, int y, TankFrame tf);
}
