package com.example.thread;

/**
 * @Author: jackhe
 * @Description: 龟兔赛跑线程问题
 * @Date: Created in 19:21 2019/3/24
 * @Modified By:
 */
public class ThreadTest2 implements Animal.CallToBack{

    Animal animal;

    public ThreadTest2(Animal animal)
    {
        this.animal = animal;
    }

    @Override
    public void win() {
        //线程终止
        animal.stop();
    }
}
