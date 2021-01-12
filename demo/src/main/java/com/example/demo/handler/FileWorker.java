package com.example.demo.handler;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileWorker {
    //private String fileName;

    public FileWorker(String fileName, String solution)
    {
        try {
            File file = new File("C:\\Users\\TambovcevGO\\idea\\homework_check_system\\demo\\src\\main\\java\\com\\example\\demo\\handler\\tasks\\" + fileName);
            file.mkdir();
            File wfile = new File("C:\\Users\\TambovcevGO\\idea\\homework_check_system\\demo\\src\\main\\java\\com\\example\\demo\\handler\\tasks\\" + fileName, fileName + ".java");
            wfile.setWritable(true);
            wfile.setReadable(true);
            wfile.setExecutable(true);
            FileOutputStream fis = new FileOutputStream(wfile);
            FileWriter fileWriter = new FileWriter(wfile, false);
            fileWriter.write(solution);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
