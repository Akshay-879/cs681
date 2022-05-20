package edu.umb.cs681.hw15;

import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Directory extends FSElement {

    private ConcurrentLinkedQueue<FSElement> child;

    public Directory(String name, int size, LocalDateTime creationTime, Directory parent) {
        super(name, size, creationTime, parent);
        if (parent != null)
            parent.appendChild(this);

    }

    @Override
    public boolean isDirectory() {
        return true;
    }

    public ConcurrentLinkedQueue<FSElement> getChildren() {
        return child;
    }
    public void appendChild(FSElement child) {
        if(this.child == null) {
            this.child = new ConcurrentLinkedQueue<>();
        }
        this.child.add(child);
    }
    public int countChildren() {
        return getChildren().size();
    }
    public ConcurrentLinkedQueue<Directory> getSubDirectories() {
        ConcurrentLinkedQueue<Directory> listDirectories = new ConcurrentLinkedQueue<>();
        for(FSElement s : getChildren()) {
            if(s instanceof Directory)
                listDirectories.add((Directory) s);
        }
        return listDirectories;
    }
    public ConcurrentLinkedQueue<File> getFiles() {
        ConcurrentLinkedQueue<File> listfile = new ConcurrentLinkedQueue<>();
        for(FSElement s : getChildren()) {
            if(s instanceof File)
                listfile.add((File)s);
        }
        return listfile;
    }
    public int getTotalSize() {
        int totalSize = 0;
        for(FSElement e : getChildren()) {
            if(e instanceof Directory)
                totalSize += ((Directory) e).getTotalSize();
            else
                totalSize += e.getSize();
        }
        return totalSize;
    }

}
