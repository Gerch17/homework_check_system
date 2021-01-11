package com.example.demo.handler.java;

import java.io.*;
import java.nio.Buffer;

public class ConsoleWorker {
    private String[] commands;
    private ProcessBuilder process;
    private Process isRun;

    ConsoleWorker(String name) throws IOException {
        commands = new String[]{"java", name + ".java"};
        process = new ProcessBuilder(commands);
        //PUT HERE YOUR OWN PATH
        process.directory(new File("D:\\Krok\\CROC-Coder\\Handler\\src\\main\\tasks"));
        try {
            isRun = process.start();
        } catch (IOException e) {
            System.out.println("Error: Process hasn`t been started");
        }
    }

    public String getTestData() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(isRun.getInputStream()));
        String line;
        StringBuilder data = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            data.append(line);
        }
        return data.toString();
    }

    public void setTestData(String data) {
        OutputStream out = isRun.getOutputStream();
        PrintStream printStream = new PrintStream(out);
        printStream.println(data);
        printStream.flush();
    }
}