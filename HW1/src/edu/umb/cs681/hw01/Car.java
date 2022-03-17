package edu.umb.cs681.hw01;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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


        System.out.println("Ordered by Mileage:");
        List<Car> orderedByMileage = (List)Car_list.stream().sorted(Comparator.comparingInt(Car::getMileage)).collect(Collectors.toList());
        PrintStream var10001 = System.out;
        Objects.requireNonNull(var10001);
        orderedByMileage.forEach(var10001::println);


        System.out.println("Ordered by Make:");
        List<Car> orderedByMake = (List)Car_list.stream().sorted(Comparator.comparing(Car::getMake)).collect(Collectors.toList());
        var10001 = System.out;
        Objects.requireNonNull(var10001);
        orderedByMake.forEach(var10001::println);


        System.out.println("Ordered by Domination Count:");
        List<Car> orderedByDomCount = (List)Car_list.stream().sorted(Comparator.comparingInt(Car::getDominationCount)).collect(Collectors.toList());
        var10001 = System.out;
        Objects.requireNonNull(var10001);
        orderedByDomCount.forEach(var10001::println);


        System.out.println("Ordered by Model:");
        List<Car> orderedByModel = (List)Car_list.stream().sorted(Comparator.comparing(Car::getModel)).collect(Collectors.toList());
        var10001 = System.out;
        Objects.requireNonNull(var10001);
        orderedByModel.forEach(var10001::println);
    }
}

