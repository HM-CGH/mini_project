package com.humanmedi.miniproject.stage;
import java.util.List;
import java.util.Random;

public interface MonsterSpawner {
    default Monster getRandomMonster(List<Monster> monsters){
        Random random = new Random();
        return monsters.get(random.nextInt(monsters.size()));
    }

    Monster spawnMonster();
}
