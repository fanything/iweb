package com.we.script;

import java.io.*;
import java.nio.file.Files;

public class AppMain {
    public static void main(String[] args) throws IOException {

        String path = "D:/books2";

        File file = new File("D:/books");
        if(file.isDirectory()){
            File[] flist = file.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.contains(".jpg");
                }
            });

            for(File f:flist){
                String name = f.getName();
                String newName = name.split(".jpg")[0]+".jpg";
                Files.copy(f.toPath(),new FileOutputStream(new File(path + "/" + newName)));
            }
        }
    }
}
