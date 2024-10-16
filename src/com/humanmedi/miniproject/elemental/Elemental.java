package com.humanmedi.miniproject.elemental;

public enum Elemental {
    FIRE,
    WATER,
    WOOD;

    public static Elemental getElemental(){
        Elemental[] elementals = values();
        int random_elemental = (int) (Math.random() * elementals.length);
        return elementals[random_elemental];
    }
}
