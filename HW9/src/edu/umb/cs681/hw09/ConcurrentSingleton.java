package edu.umb.cs681.hw09;

import java.util.concurrent.atomic.AtomicReference;

public class ConcurrentSingleton {

    private ConcurrentSingleton() {

    }

    private static AtomicReference<ConcurrentSingleton> temp = new AtomicReference<ConcurrentSingleton>();

    public static void setTemp(AtomicReference<ConcurrentSingleton> temp) {
        ConcurrentSingleton.temp = temp;
    }

    public static AtomicReference<ConcurrentSingleton> getInstance() {
        try{
            if (temp.get() == null) {
                temp.set(new ConcurrentSingleton());
            }
            return temp;
        }finally {

        }

    }
}
