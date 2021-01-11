package com.example.demo.handler.java;

import java.io.DataInputStream;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        Broker broker = new Broker(1);
        System.out.println(broker.runTest(1,1,"Test"));
    }
}
