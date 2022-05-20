package edu.umb.cs681.hw09;


public class Main {

    public static void main(String[] args){
        for(int i=0; i<10; i++){
            new Thread(
                    ()->{System.out.println(ConcurrentSingleton.getInstance());}).start();
        }
    }
}
