package com.example.thread;

/**
 * @Author: jackhe
 * @Description:
 * @Date: Created in 18:54 2019/3/24
 * @Modified By:
 */
public class PersonA extends Thread {
    Bank bank;

    String mode;

    public PersonA(Bank bank,String mode)
    {
        this.mode = mode;
        this.bank = bank;
    }

    @Override
    public void run()
    {
        while (bank.money >= 1000)
        {
            try {
                bank.outMoney(1000.0,mode);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                sleep(1000);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
