package edu.umb.cs681.hw11;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

public class AccessCounter {


    private HashMap<java.nio.file.Path, Integer> hashmap = new HashMap<java.nio.file.Path, Integer>();
    private ReentrantLock NS_lock = new ReentrantLock();
    private static ReentrantLock S_lock = new ReentrantLock();
    private static AccessCounter instance = null;


    public AccessCounter() {
    }

    public void increment(Path path){
        NS_lock.lock();
        try{
            if (hashmap.containsKey(path)){
                hashmap.put(path, hashmap.get(path)+1);
            }else{
                hashmap.putIfAbsent(path, 1);
            }
        }finally {
            NS_lock.unlock();
        }
    }

    public int getCount(Path path){
        S_lock.lock();
        try{
            if(hashmap.containsKey(path)){
                return hashmap.get(path);
            }else{
                return 0;
            }
        }finally {
            S_lock.unlock();
        }
    }

    public static AccessCounter getInstance(){
        S_lock.lock();
        try{
            if (instance == null)
                instance = new AccessCounter();
            return instance;

        }finally {
            S_lock.unlock();
        }
    }

}
