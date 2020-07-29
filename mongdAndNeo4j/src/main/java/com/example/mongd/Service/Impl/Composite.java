package com.example.mongd.Service.Impl;

import com.example.mongd.Service.Component;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {

    List<Component> components = new ArrayList<>();

    public void addComponent(Component component){
        components.add(component);
    }

    public void removeComponent(Component component){
        this.components.remove(component);
    }

    @Override
    public void doSomething(String in) {
        for (Component component : components) {
            component.doSomething(in);
        }
    }
}
