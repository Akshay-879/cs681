package edu.umb.cs681.hw10;

public class run implements Runnable{

    public void run(){

        Position position = new Position(40.7128, 74.0060, 35000);
        Aircraft aircraft = new Aircraft(position);

        System.out.println("Original Aircraft position is:" + aircraft.getPosition() + " at altitude: " + aircraft.getPosition().getAltitude() + " Feet");

        aircraft.setPosition(new Position(37.7749, 122.4194, 2000));

        System.out.println("Current position of the Aircraft is: " + aircraft.getPosition() + " at altitude: " + aircraft.getPosition().getAltitude() + " Feet");
    }

    public static void main(String[] args) {

        Thread T1 = new Thread(new run());
        Thread T2 = new Thread(new run());

        T1.start();
        T2.start();

        try {
            T1.join();
            T2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
