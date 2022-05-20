package edu.umb.cs681.hw14;

import java.nio.file.Path;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class RevisedAccessCounter {

    private ConcurrentHashMap<Path, AtomicInteger> hashmap = new ConcurrentHashMap<java.nio.file.Path, AtomicInteger>();
    private static ReentrantLock S_Lock = new ReentrantLock();
    private static RevisedAccessCounter instance = null;

    public RevisedAccessCounter() {
    }

    public void increment(Path path){
        if (hashmap.containsKey(path)){
            hashmap.get(path).incrementAndGet();
        }else{
            hashmap.putIfAbsent(path, new AtomicInteger(1));
        }
    }

    public int getCount(Path path){
        if(hashmap.containsKey(path)){
            return hashmap.get(path).get();
        }else {
            return 0;
        }
    }

    public static RevisedAccessCounter getInstance(){
        S_Lock.lock();
        try {
            if (instance == null)
                instance = new RevisedAccessCounter();
            return instance;
        }finally {
            S_Lock.unlock();
        }

    }


}
