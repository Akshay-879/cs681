package edu.umb.cs681.hw12;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class FileSystem implements Runnable{

    private LinkedList<Directory> directoryroot;
    private static FileSystem instance = null;

    private FileSystem() {
    }

    void addRootDir(Directory Rootdirectory) {
        directoryroot = new LinkedList<Directory>();
        directoryroot.add(Rootdirectory);
    }

    public static FileSystem getFileSystem() {
        if(instance==null)
            instance = new FileSystem ();
        return instance;
    }

    public LinkedList<Directory> getRootDirs() {
        return this.directoryroot;
    }

    public void run() {
        System.out.println("\n" +"Root Directory: " + getRootDirs().get(0).getName() + ", Size: " + getRootDirs().get(0).getSize());
        System.out.println("\n" + "Root has following directories: ");
        LinkedList<FSElement> directory = getRootDirs().get(0).getChildren();
        for (FSElement d: directory){
            System.out.println("Name: " + d.getName() + ", Size: " + d.getSize());
        }
    }


    public static void main(String args[]) {

        LocalDateTime localTime = LocalDateTime.now();

        Directory root = new Directory("CS682 Project",100000,localTime,null);
        Directory applications = new Directory("City-Wise Surface Plots", 0,localTime, root);
        Directory home = new Directory("County-Wise Surface Plots", 0,localTime,root);
        Directory code = new Directory("Keplergl Map", 0, localTime,root);
        File a = new File("a", 430, localTime,applications);
        File b = new File("b", 579,localTime,applications);
        File c = new File("c", 340,localTime,home);
        File d = new File( "d", 280,localTime,home);
        File e = new File("e", 680,localTime, code);
        File f = new File("f", 356,localTime,code);
        FileSystem.getFileSystem().addRootDir(root);


        Thread t1 = new Thread(getFileSystem());
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }


        Thread t2 = new Thread(getFileSystem());
        t2.start();
        try {
            t2.join();
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }

        Thread t3 = new Thread(getFileSystem());
        t3.start();
        try {
            t3.join();
        } catch (InterruptedException e3) {
            e3.printStackTrace();
        }

    }


}