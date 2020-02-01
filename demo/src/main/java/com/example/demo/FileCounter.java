package com.example.demo;

import java.io.File;
import java.util.ArrayList;

public class FileCounter {
    ArrayList<File> fileList;
    File root;

    public FileCounter(String pathName) {
        root = new File(pathName);
        fileList = new ArrayList<>();
    }

    public void searchFiles() {
        File[] files = root.listFiles();
        int length = files.length;
        for (int i = 0; i < length; i++) {
            if (files[i].isDirectory()) {
                root = files[i];
                searchFiles();
            } else {
                fileList.add(files[i]);
            }
        }
    }

    public void countFiles() {

        long totalSize = 0;
        System.out.println("文件数:" + fileList.size());
        for (int i = 0; i < fileList.size(); i++) {
            totalSize += fileList.get(i).length();
            File file = fileList.get(i);
            System.out.println(file.getName());
            //System.out.println(fileList.get(i).length());
        }
        System.out.println("文件总大小:" + totalSize);
    }

    public static void main(String[] args) {
        String pathName = "/Users/mac/git/spring_boot_demo/demo/src";
        FileCounter counter = new FileCounter(pathName);
        counter.searchFiles();
        counter.countFiles();
    }

}
