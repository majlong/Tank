package com.mjl.tank;

/**
 * @Auther: mjl
 * @Date: 2020/6/24 - 13:30
 * @Description: 开火，这里用到了策略模式
 * @version: 1.0
 */
public interface FireStrategy {
    /**
     * 要传tank ,不然不知道开火在什么位置上
     * @param tank
     */
    void fire(Tank tank);
}
