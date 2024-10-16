package com.humanmedi.miniproject.stage;

import java.util.HashMap;

import com.humanmedi.miniproject.elemental.Elemental;
import com.humanmedi.miniproject.entity.enemy.Enemy;

public class Monster {
    private Enemy type;
    private String name;
    private boolean isAlive;
    private boolean alive;
    private boolean isActable;
    private boolean actable;
    private float health;
    private int power;
    private Elemental elemental;

    public Monster(Enemy type, int health){
        this.type = type;
        this.isAlive = true;
        this.isActable = false;
        this.health = health;

        HashMap<Enemy, Integer> damage_map = new HashMap<>();

        damage_map.put(Enemy.ZOMBIE, 2);
        damage_map.put(Enemy.SKELETON, 4);
        damage_map.put(Enemy.CREEPER, 6);
        damage_map.put(Enemy.BLAZE, 8);
        damage_map.put(Enemy.SPIDER, 10);
        damage_map.put(Enemy.SLIME, 12);
        damage_map.put(Enemy.GOBLIN, 14);
        damage_map.put(Enemy.CAMEL, 16);
        damage_map.put(Enemy.ENDER_DRAGON, 19);

        this.power = damage_map.get(type);
    }

    public Enemy getType(){
        return type;
    }

    public int getPower(){
        return power;
    }

    public String getName(){
        return name;
    }

    public boolean isAlive(){
        return isAlive;
    }

    public boolean isActable(){
        return this.isActable;
    }
    public void setActable(boolean isActable){
        this.isActable = isActable;
    }

    public float getHealth(){
        return health;
    }

    public void setAlive(boolean alive){
        isAlive = alive;
    }

    public void takeDamage(int damage){
        System.out.println("데미지는 : " + damage);
        this.health -= damage;
        if(this.health <= 0){
            this.isAlive = false;
            this.health = 0;
        }

    }
    public void takeSkillDamage(int damage, Elemental elemental){
        float multiplier = 0f;

        switch(this.getElemental()){
            case FIRE:{
                switch(elemental){
                    case FIRE:{
                        multiplier = 1f;
                        break;
                    }
                    case WATER:{
                        multiplier = 2f;
                        break;
                    }
                    case WOOD:{
                        multiplier = 0.5f;
                        break;
                    }
                    default:{}
                }
            }
            case WATER:{
                switch(elemental){
                    case FIRE:{
                        multiplier = 0.5f;
                        break;
                    }
                    case WATER:{
                        multiplier = 1f;
                        break;
                    }
                    case WOOD:{
                        multiplier = 2f;
                        break;
                    }
                    default:{
                        
                    }
                }
            }
            case WOOD:{
                switch(elemental){
                    case FIRE:{
                        multiplier = 2f;
                        break;
                    }
                    case WATER:{
                        multiplier = 0.5f;
                        break;
                    }
                    case WOOD:{
                        multiplier = 1f;
                        break;
                    }
                    default:{
                        
                    }
                }
            }
            default:{

            }
        }

        System.out.println("데미지는 : " + damage);
        final float final_damage = damage * multiplier;

        this.health -= final_damage;

        if(this.health <= 0){
            this.isAlive = false;
            this.health = 0;
        }
    }

    public void setElemental(Elemental elemental){
        this.elemental = elemental;
    }
    public Elemental getElemental(){
        return this.elemental;
    }

    @Override
    public String toString(){
        return name + "(Health: " + health + ")";
    }
}
