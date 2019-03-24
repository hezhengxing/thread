package com.example.thread;

/**
 * @Author: jackhe
 * @Description:
 * @Date: Created in 19:03 2019/3/24
 * @Modified By:
 */
public class PersonB extends Thread {
    Bank bank;

    String mode;

    public PersonB(Bank bank,String mode)
    {
        this.bank = bank;
        this.mode = mode;
    }

    @Override
    public void run()
    {
        while (bank.money >= 2000)
        {
            try {
                bank.outMoney(2000.0, mode);
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            try {
                sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
