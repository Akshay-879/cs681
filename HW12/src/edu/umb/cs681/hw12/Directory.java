package edu.umb.cs681.hw12;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class Directory extends FSElement {

    private LinkedList<FSElement> child;

    public Directory(String name, int size, LocalDateTime creationTime, Directory parent) {
        super(name, size, creationTime, parent);
        if (parent != null)
            parent.appendChild(this);

    }

    @Override
    public boolean isDirectory() {
        return true;
    }



    public LinkedList<FSElement> getChildren() {
        return child;
    }
    public void appendChild(FSElement child) {
        if(this.child == null) {
            this.child = new LinkedList<FSElement>();
        }
        this.child.add(child);
    }
    public int countChildren() {
        return getChildren().size();
    }
    public LinkedList<Directory> getSubDirectories() {
        LinkedList<Directory> listDirectories = new LinkedList<Directory>();
        for(FSElement s : getChildren()) {
            if(s instanceof Directory)
                listDirectories.add((Directory) s);
        }
        return listDirectories;
    }
    public LinkedList<File> getFiles() {
        LinkedList<File> listfile = new LinkedList<File>();
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
