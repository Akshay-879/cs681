package edu.umb.cs681.hw16;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String make;
    private String model;
    private int mileage;
    private int year;
    private float price;
    private int dominationCount;

    public Car(String make, String model, int year, int mileage, float price, int dominationCount) {
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

    public float getPrice() {
        return this.price;
    }

    public int getMileage() {
        return this.mileage;
    }

    public static void main(String[] args) {


        List<Car> Car_list = new ArrayList();
        Car_list.add(new Car("Lykn", "Hypersport", 2019, 3, 1.0E7F, 1));
        Car_list.add(new Car("Venom", "GT", 2018, 4, 2.0E7F, 3));
        Car_list.add(new Car("Buggati", "Vyron", 2020, 2, 1.5E7F, 2));
        Car_list.add(new Car("Mercedes", "AMG", 2016, 12, 1000000.0F, 4));


        float Price = Car_list.stream().parallel().map((Car car) -> car.getPrice())
                .reduce((float) 0, (result, price) ->  result > price ? result : price);

        System.out.println("Most expensive car in the list has price = $" + Price);


        int Domination = Car_list.stream().parallel().map((Car car) -> car.getDominationCount())
                .reduce(0, (result, dom_count) ->  result > dom_count ? result : dom_count);

        System.out.println("Highest dominant number for a car is: " + Domination);

        int Mileage = Car_list.stream().parallel().map((Car car) -> car.getMileage())
                .reduce(100, (result, mileage) -> mileage > result ? result: mileage);

        System.out.println("Minimum mileage in the list of cars is: " + Mileage + "mpg");

    }
}
