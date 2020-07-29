package com.example.mongd.Service;

public abstract class Worker {
    protected Util util;

    public void setUtil(Util util){
        this.util = util;
    }

    public abstract void run();
}
