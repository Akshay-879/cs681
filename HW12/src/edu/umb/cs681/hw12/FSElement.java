package edu.umb.cs681.hw12;

import java.time.LocalDateTime;
import java.util.concurrent.locks.ReentrantLock;

public abstract class FSElement {
    private String Name;
    private int Size;
    private LocalDateTime CreationTime;
    private Directory Parent;
    protected ReentrantLock lock = new ReentrantLock();

    public FSElement(String name, int size, LocalDateTime creationTime, Directory parent) {
        Name = name;
        Size = size;
        CreationTime = creationTime;
        Parent = parent;
    }

    public abstract boolean isDirectory();

    public String getName() {
        lock.lock();
        try{
            return Name;
        }finally {
            lock.unlock();
        }

    }

    public int getSize() {
        lock.lock();
        try{
            return Size;
        }finally {
            lock.unlock();
        }

    }

    public LocalDateTime getCreationTime() {
        lock.lock();
        try{
            return CreationTime;
        }finally {
            lock.unlock();
        }

    }

    public Directory getParent() {
        lock.lock();
        try{
            return Parent;
        }finally {
            lock.unlock();
        }

    }
}
