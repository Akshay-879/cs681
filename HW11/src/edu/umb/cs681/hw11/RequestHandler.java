package edu.umb.cs681.hw11;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class RequestHandler implements Runnable {

    private ReentrantLock lock = new ReentrantLock();
    private boolean done = false;

    public void setDone() {
        lock.lock();
        try {
            done = true;
        }
        finally {
            lock.unlock();
        }
    }

    public void run(){

        List<String> files = new ArrayList<>();
        files.add("temp1.html");
        files.add("temp2.html");
        files.add("temp3.html");

        AccessCounter accessCounter = AccessCounter.getInstance();

        while (true){
            lock.lock();
            try{
                if (done == true){
                    break;
                }

                int file_num = new Random().nextInt(files.size());
                Path path = Paths.get(files.get(file_num));

                accessCounter.increment(path);
                System.out.println("Path: " + path + ", Count: " + accessCounter.getCount(path));
            }finally {

                lock.unlock();
            }

            try {
                Thread.sleep(2000);
            }catch (InterruptedException e){
                System.out.println(e.toString());
                continue;
            }
        }
    }

    public static void main(String[] args) {

        RequestHandler requestHandler1  = new RequestHandler();
        RequestHandler requestHandler2  = new RequestHandler();
        RequestHandler requestHandler3  = new RequestHandler();
        RequestHandler requestHandler4  = new RequestHandler();
        RequestHandler requestHandler5  = new RequestHandler();
        RequestHandler requestHandler6  = new RequestHandler();
        RequestHandler requestHandler7  = new RequestHandler();
        RequestHandler requestHandler8  = new RequestHandler();
        RequestHandler requestHandler9  = new RequestHandler();
        RequestHandler requestHandler10 = new RequestHandler();
        RequestHandler requestHandler11 = new RequestHandler();

        Thread thread1  = new Thread(requestHandler1);
        Thread thread2  = new Thread(requestHandler2);
        Thread thread3  = new Thread(requestHandler3);
        Thread thread4  = new Thread(requestHandler4);
        Thread thread5  = new Thread(requestHandler5);
        Thread thread6  = new Thread(requestHandler6);
        Thread thread7  = new Thread(requestHandler7);
        Thread thread8  = new Thread(requestHandler8);
        Thread thread9  = new Thread(requestHandler9);
        Thread thread10 = new Thread(requestHandler10);
        Thread thread11 = new Thread(requestHandler11);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();
        thread9.start();
        thread10.start();
        thread11.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        requestHandler1.setDone();
        requestHandler2.setDone();
        requestHandler3.setDone();
        requestHandler4.setDone();
        requestHandler5.setDone();
        requestHandler6.setDone();
        requestHandler7.setDone();
        requestHandler8.setDone();
        requestHandler9.setDone();
        requestHandler10.setDone();
        requestHandler11.setDone();

        thread1.interrupt();
        thread2.interrupt();
        thread3.interrupt();
        thread4.interrupt();
        thread5.interrupt();
        thread6.interrupt();
        thread7.interrupt();
        thread8.interrupt();
        thread9.interrupt();
        thread10.interrupt();
        thread11.interrupt();

        try{
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
            thread6.join();
            thread7.join();
            thread8.join();
            thread9.join();
            thread10.join();
            thread11.join();
        }catch (InterruptedException e){
            System.out.println(e.toString());
        }

    }

}
