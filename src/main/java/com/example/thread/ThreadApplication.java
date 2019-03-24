package com.example.thread;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ThreadApplication {

	public static void main(String[] args) {

		SpringApplication.run(ThreadApplication.class, args);

		//实例化站台对象，并为每一个站台取名字
		ThreadTest threadTest1 = new ThreadTest("窗口1");
		ThreadTest threadTest2 = new ThreadTest("窗口2");
		ThreadTest threadTest3 = new ThreadTest("窗口3");

		//让每一个站台开始工作
		threadTest1.start();
		threadTest2.start();
		threadTest3.start();

		Bank bank = new Bank();

		PersonA personA = new PersonA(bank,"save");
		PersonB personB = new PersonB(bank,"count");

		personA.start();
		personB.start();

		// 实例化乌龟和兔子
		Tortoise tortoise = new Tortoise();
		Rabbit rabbit = new Rabbit();
		// 回调方法的使用，谁先调用calltoback方法，另一个就不跑了
		ThreadTest2 letOneStop1 = new ThreadTest2(tortoise);
		// 让兔子的回调方法里面存在乌龟对象的值，可以把乌龟stop
		rabbit.callToBack = letOneStop1;
		ThreadTest2 letOneStop2 = new ThreadTest2(rabbit);
		// 让乌龟的回调方法里面存在兔子对象的值，可以把兔子stop
		tortoise.callToBack = letOneStop2;
		// 开始跑
		tortoise.start();
		rabbit.start();
	}

}
