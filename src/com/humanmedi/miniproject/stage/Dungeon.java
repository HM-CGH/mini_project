package com.humanmedi.miniproject.stage;

import com.humanmedi.miniproject.elemental.Elemental;

import java.util.ArrayList;
import java.util.List;

public class Dungeon implements MonsterSpawner{
	
	public List<Monster> monster = new ArrayList<>();
   
	public Dungeon() {
        monster.add(new Monster("Zombie"));
        monster.add(new Monster("Skeleton"));
        monster.add(new Monster("Creeper"));
        monster.add(new Monster("Blaze"));
        monster.add(new Monster("Spider"));
        monster.add(new Monster("Slime"));
        monster.add(new Monster("Goblin"));
        monster.add(new Monster("camel"));
        monster.add(new Monster("Ender Dragon"));
	}
	
	
    public void spawnMonster(){


        Monster random_monster = getRandomMonster(monster);

        Elemental random_elemental = Elemental.getElemental();

    }
}
