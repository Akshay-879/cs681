package edu.umb.cs681.hw18;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorRunnable implements Runnable {

    public void run(){

        Aircraft aircraft = new Aircraft(new Position(40.7128,74.0060,35000));

        System.out.println("Original Aircraft position is:" + aircraft.getPosition() + " at altitude: " + aircraft.getPosition().getAltitude() + " Feet");

        aircraft.setPosition(new Position(37.7749, 122.4194, 2000));

        System.out.println("Current position of the Aircraft is: " + aircraft.getPosition() + " at altitude: " + aircraft.getPosition().getAltitude() + " Feet");

//        aircraft.setPosition(new Position(37.7749, 122.4194,0));

//        System.out.println("Current position of the Aircraft is: " + aircraft.getPosition() + " at altitude: " + aircraft.getPosition().getAltitude() + " Feet");
//        System.out.println("The plane has landed on its destination.");
//        System.out.println("############################################################################################################################");
    }

    public static void main(String[] args) {

        Thread T1 = new Thread(new ExecutorRunnable());
        Thread T2 = new Thread(new ExecutorRunnable());
        Thread T3 = new Thread(new ExecutorRunnable());
        Thread T4 = new Thread(new ExecutorRunnable());

        ExecutorService executor = Executors.newFixedThreadPool(4);

        executor.execute(T1);
        executor.execute(T2);
        executor.execute(T3);
        executor.execute(T4);

        executor.shutdown();

        try {
            executor.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
