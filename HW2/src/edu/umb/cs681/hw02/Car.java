package edu.umb.cs681.hw02;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String make;
    private String model;
    private int mileage;
    private int year;
    private int price;
    private int dominationCount;

    public Car(String make, String model, int year, int mileage, int price, int dominationCount) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
        this.dominationCount = dominationCount;
    }

    public int getDominationCount() {
        return this.dominationCount;
    }

    public String getMake() {
        return this.make;
    }

    public String getModel() {
        return this.model;
    }

    public int getYear() {
        return this.year;
    }

    public int getPrice(){
        return this.price;
    }

    public int getMileage() {
        return this.mileage;
    }

    public static void main(String[] args) {

        List<Car> Car_list = new ArrayList();
        Car_list.add(new Car("Lykn", "Hypersport", 2019, 3, 10000000, 1));
        Car_list.add(new Car("Venom", "GT", 2018, 4, 20000000, 3));
        Car_list.add(new Car("Buggati", "Vyron", 2020, 2, 15000000, 2));
        Car_list.add(new Car("Mercedes", "AMG", 2016, 12, 100000, 4));



        //max() with reduce.
        int max_cost = Car_list.stream().map((Car car) ->car.getPrice() )
                .reduce(0, (result,price)->result > price ? result : price);

        System.out.println("Price of most expensive car is $"+max_cost);


        //min() with reduce

        int min_cost = Car_list.stream().map((Car car) ->car.getPrice() )
                .reduce(1000000000, (result, price)->price>result ? result : price);

        System.out.println("Price of cheapest car $"+min_cost);

        int avg_cost = Car_list.stream().map((Car car) ->car.getPrice() )
                .reduce(0, (result,price) -> result+price, (finalResult, intermediateResult) -> finalResult)/Car_list.size();

        System.out.println("Avg price for the available cars is: " + avg_cost);
    }
}

