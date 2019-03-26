package com.example.thread;

/**
 * @Author: jackhe
 * @Description:
 * @Date: Created in 21:36 2019/3/24
 * @Modified By:
 */
public class Tortoise extends Animal{

    public Tortoise()
    {
        setName("乌龟");
    }

    @Override
    public void running() {
        // 乌龟速度
        int dis = 30;
        if (length >= 30){
            length -= dis;
        }else{
            length=0;
        }
        System.out.println("乌龟跑了" + dis + "米，距离终点还有" + length + "米");
        if (length <= 0) {
            length = 0;
            System.out.println("乌龟获得了胜利");
            // 让兔子不要在跑了
            if (callToBack != null) {
                callToBack.win();
            }
        }
        try {
            sleep(100);						//每0.1秒跑2米
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
