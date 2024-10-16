package com.humanmedi.miniproject.stage;

import com.humanmedi.miniproject.elemental.Elemental;
import com.humanmedi.miniproject.entity.enemy.Enemy;
import com.humanmedi.miniproject.item.WeaponItem;
import com.humanmedi.miniproject.item.Material;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dungeon implements MonsterSpawner{

    public List<Monster> monster = new ArrayList<>();

    public Dungeon() {
        monster.add(new Monster(Enemy.ZOMBIE,getRandomHealth()));
        monster.add(new Monster(Enemy.SKELETON,getRandomHealth()));
        monster.add(new Monster(Enemy.CREEPER,getRandomHealth()));
        monster.add(new Monster(Enemy.BLAZE,getRandomHealth()));
        monster.add(new Monster(Enemy.SPIDER,getRandomHealth()));
        monster.add(new Monster(Enemy.SLIME,getRandomHealth()));
        monster.add(new Monster(Enemy.GOBLIN,getRandomHealth()));
        monster.add(new Monster(Enemy.CAMEL,getRandomHealth()));
        monster.add(new Monster(Enemy.ENDER_DRAGON,getRandomHealth()));
    }


    public Monster spawnMonster(){

        // 랜덤 몬스터 소환
        Monster random_monster = getRandomMonster(monster);
        random_monster.setElemental(Elemental.getElemental());
        //System.out.println("소환된 몬스터" + random_monster);
        //random_monster.takeDamage(150);


        return random_monster;

    }

    // 몬스터 체력 랜덤 부여
    private int getRandomHealth(){
        Random random = new Random();
        return random.nextInt(5)+2;
    }

    // 무기 드롭
    public WeaponItem dropWeapon(Elemental elemental) {
        Random random = new Random();

        // 무기 선택
        WeaponItem weapon = new WeaponItem(getRandomMaterial());

        // setDamage에 따른 무기 드롭 확률 (데미지가 클수록 확률 감소)
        int drop_Chance = 100 - weapon.getDamage() * 10; // 데미지가 클수록 확률 감소
        int random_Chance = random.nextInt(100);

        // 무기 드롭
        if (random_Chance < drop_Chance) {
            System.out.println("무기를 얻었습니다: " + weapon.getMaterial() + " (Element: " + elemental + ")");
            System.out.println("무기 소환 확률: " + drop_Chance);

            return weapon;
        } else {
            System.out.println("무기를 얻지 못했습니다.");

            return null;
        }

    }

    // 
    private Material getRandomMaterial() {
        Material[] materials = Material.values();
        int randomIndex = (int) (Math.random() * materials.length);
        return materials[randomIndex];
    }

//     public static void main(String[] args) {
//         Dungeon dungeon = new Dungeon();
//        dungeon.spawnMonster();
//    }

}
