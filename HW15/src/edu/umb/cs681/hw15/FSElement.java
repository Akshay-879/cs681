package edu.umb.cs681.hw15;

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
        return Name;
    }

    public int getSize() {
        return Size;
    }

    public LocalDateTime getCreationTime() {
        return CreationTime;
    }

    public Directory getParent() {
        return Parent;
    }
}
