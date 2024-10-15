package com.humanmedi.miniproject.elemental;

public enum Elemental {
    FIRE,
    WATER,
    WOOD;

    public static Elemental getElemental(){
        Elemental[] elementals = values();
        int randomElemental = (int) (Math.random() * elementals.length);
        return elementals[randomElemental];
    }
}
