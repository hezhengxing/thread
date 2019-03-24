package com.example.thread;

import java.util.Objects;

/**
 * @Author: jackhe
 * @Description: 两个人AB通过一个账户A在柜台取钱和B在ATM机取钱！
 * @Date: Created in 18:43 2019/3/24
 * @Modified By:
 */
public class Bank {
    static Double money = 10000.0;

    /**
     * 取钱的方法
     * @param money
     */
    private void counter(Double money)
    {
        Bank.money -= money;
        System.out.println("ATM本次取钱" + money + "元,账户余额" + Bank.money + "元!");
    }

    /**
     * 存钱的方法
     * @param money
     */
    private void saveMaoney(Double money)
    {
        Bank.money -= money;
        System.out.println("柜台本次取钱" + money + "元,账户余额" + Bank.money + "元!");
    }

    /**
     * 提供一个对外取款途径，防止直接调取方法同时取款时，并发余额显示错误
     * @param money
     * @param mode
     * @throws Exception
     */
    public synchronized void outMoney(Double money,String mode) throws Exception {
        if (money > Bank.money)
        {
            throw new Exception("取款金额"+money+",余额只剩"+Bank.money+"，取款失败");
        }
        if (Objects.equals(mode, "save"))
        {
            saveMaoney(money);
        }
        else {
            counter(money);
        }
    }
}
