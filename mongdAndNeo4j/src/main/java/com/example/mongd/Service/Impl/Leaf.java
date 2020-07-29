package com.example.mongd.Service.Impl;

import com.example.mongd.Service.Component;

import java.io.Console;
import java.io.PrintStream;

public class Leaf implements Component {
    @Override
    public void doSomething(String in) {
        PrintStream leaf = System.out.append("Leaf");
        leaf.append(" can print").println(in);
    }
}
