package com.example.thread;

/**
 * @Author: jackhe
 * @Description:
 * @Date: Created in 20:03 2019/3/24
 * @Modified By:
 */
public abstract class Animal extends Thread {

    public int length = 2000;

    public abstract void running();

    @Override
    public void run()
    {
        super.run();
        while (length > 0)
        {
            running();
        }
    }

    /**
     * 在需要回调数据的地方
     */
    public static interface CallToBack{
        public void win();
    }

    //创建借口对象
    public CallToBack callToBack;
}
