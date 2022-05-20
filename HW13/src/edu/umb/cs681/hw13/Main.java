package edu.umb.cs681.hw13;

public class Main {

    public static void main(String[] args){

        ThreadSafeBankAccount2 account = new ThreadSafeBankAccount2();
        WithdrawRunnable withdraw = new WithdrawRunnable(account);
        DepositRunnable deposit = new DepositRunnable(account);

        Thread deposit_1  = new Thread(deposit);
        Thread deposit_2  = new Thread(deposit);
        Thread deposit_3  = new Thread(deposit);
        Thread deposit_4  = new Thread(deposit);

        Thread withdraw_1  = new Thread(withdraw);
        Thread withdraw_2  = new Thread(withdraw);
        Thread withdraw_3  = new Thread(withdraw);
        Thread withdraw_4  = new Thread(withdraw);

        deposit_1.start();
        deposit_2.start();
        deposit_3.start();
        deposit_4.start();

        withdraw_1.start();
        withdraw_2.start();
        withdraw_3.start();
        withdraw_4.start();

        deposit.setDone();
        withdraw.setDone();

        deposit_1.interrupt();
        deposit_2.interrupt();
        deposit_3.interrupt();
        deposit_4.interrupt();

        withdraw_1.interrupt();
        withdraw_2.interrupt();
        withdraw_3.interrupt();
        withdraw_4.interrupt();

        try{
            deposit_1.join();
            deposit_2.join();
            deposit_3.join();
            deposit_4.join();

            withdraw_1.join();
            withdraw_2.join();
            withdraw_3.join();
            withdraw_4.join();

        }catch (InterruptedException e){
            System.out.println(e.toString());
        }

    }


}
