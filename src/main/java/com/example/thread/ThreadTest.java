package com.example.thread;

/**
 * @Author: jackhe
 * @Description: 线程实例学习
 * @Date: Created in 18:28 2019/3/24
 * @Modified By:
 */
public class ThreadTest extends Thread{
    /**
     * 给线程命名
     * @param name
     */
    public ThreadTest(String name)
    {
        super(name);
    }

    //20张票
    static int number = 20;
    //创建一个静态钥匙
    static Object tick = "dd";

    @Override
    public void run()
    {
        while (number>0)
        {
            synchronized (tick)
            {
                if (number > 0)
                {
                    System.out.println(getName() + "卖出了第"+ number + "张票");
                    number --;
                }
                else {
                    System.out.println("票卖完了哦");
                }
            }
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
