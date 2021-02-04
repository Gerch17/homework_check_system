package com.example.demo.handler.java;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        //Checker checker = new Checker();
        Broker broker = new Broker("zxc");//(String) checker.getData().get(0));
        //long solutionID = Long.parseLong((String) checker.getData().get(2));
        System.out.println(broker.runTest("Простой вывод",1));
    }
}
