package com.humanmedi.miniproject.stage;

import com.humanmedi.miniproject.elemental.Elemental;

import java.util.ArrayList;
import java.util.List;

public class Dungeon implements MonsterSpawner{
    @Override
    public void spawnMonster(){
        List<Monster> monster = new ArrayList<>();
        monster.add(new Monster("Zombie"));
        monster.add(new Monster("Skeleton"));
        monster.add(new Monster("Creeper"));
        monster.add(new Monster("Blaze"));
        monster.add(new Monster("Spider"));
        monster.add(new Monster("Slime"));
        monster.add(new Monster("Goblin"));
        monster.add(new Monster("camel"));
        monster.add(new Monster("Ender Dragon"));

        Monster randomMonster = getRandomMonster(monster);

        Elemental randomElemental = Elemental.getElemental();

    }
}
