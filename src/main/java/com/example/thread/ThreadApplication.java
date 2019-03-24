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
	}

}
