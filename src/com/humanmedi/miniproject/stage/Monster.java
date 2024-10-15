package com.humanmedi.miniproject.stage;

public class Monster {
    private String name;

    public Monster(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString(){
        return name;
    }
}
