package com.example.demo.handler.fileWorker;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWorker {
    private String fileName;
    private final String PATH = "src/main/java/com/example/demo/handler/tasks";

    public FileWorker(String fileName, String solution)
    {
        File file = new File("C:\\Users\\TambovcevGO\\idea\\homework_check_system\\demo\\src\\main\\java\\com\\example\\demo\\handler\\tasks\\"+fileName);
        file.mkdir();

        try {
            FileWriter fileWriter = new FileWriter(fileName+".java", false);
            fileWriter.write(solution);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
