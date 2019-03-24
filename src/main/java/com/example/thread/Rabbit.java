package com.example.thread;

/**
 * @Author: jackhe
 * @Description:
 * @Date: Created in 20:07 2019/3/24
 * @Modified By:
 */
public class Rabbit extends Animal {

    public Rabbit()
    {
        setName("兔子");
    }

    @Override
    public void running() {
        int speed = 5;
        length -= speed;
        System.out.println("兔子跑了" + speed + "米，距离终点还有" + length + "米");

        if (length <=0 )
        {
            length = 0 ;
            System.out.println("兔子获得了胜利");

            if (callToBack != null)
            {
                callToBack.win();
            }
        }
        try {
            if ((2000 - length) % 20 == 0) {	// 每20米休息一次,休息时间是1秒
                sleep(1000);
            } else {				//没0.1秒跑5米
                sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
