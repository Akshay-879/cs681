package edu.umb.cs681.hw13;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeBankAccount2 {

    private double balance = 0;
    private ReentrantLock lock = new ReentrantLock();

    Condition sufficientFundsCondition= lock.newCondition();
    Condition belowUpperLimitFundsCondition= lock.newCondition();

    public ThreadSafeBankAccount2() {
    }

    public void deposit(double amount){

        lock.lock();
        try{
            while(balance >= 300){
                try {
                    belowUpperLimitFundsCondition.await();
                }catch (InterruptedException e){
//                    System.out.println(e.toString());
                    return;
                }
                balance +=amount;
                System.out.println("Amount deposited: " + amount +  " Current balance is: " + balance);
                sufficientFundsCondition.signalAll();
            }
        }finally {
            lock.unlock();
        }
    }

    public void withdraw(double amount){

        lock.lock();
        try{
            while(balance <= 0){
                try {
                    sufficientFundsCondition.await();
                }catch (InterruptedException e){
//                    System.out.println(e.toString());
                    return;
                }
                balance -=amount;
                System.out.println("Amount withdrawn: " + amount +  " Current balance is: " + balance);
                belowUpperLimitFundsCondition.signalAll();
            }
        }finally {
            lock.unlock();
        }
    }

}
