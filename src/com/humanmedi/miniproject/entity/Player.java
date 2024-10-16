package com.humanmedi.miniproject.entity;

import com.humanmedi.miniproject.inventory.Inventory;

public class Player implements Entity{
	private String name;
	private float health;
	private float maxHealth;
	private int damage;
	private int mana;
	private int maxMana;
	
	private Inventory inventory;
	
	
	/**
	 * 플레이어를 생성하는 생성자
	 * @param name 플레이어 이름
	 */
	public Player(String name) {
		this.inventory = new Inventory();
		
		this.name = name;
		this.health = 20f;
		this.maxHealth = this.health;
		this.damage = 1;
		this.mana = 20;
		this.maxMana = this.mana;
	}
	
	/**
	 * 일정 양 만큼 플레이어를 치유합니다. 최대 체력 최대치는 maxHealth를 넘을 수 없습니다
	 * @param amount 플레이어가 회복하는 양
	 */
	public void heal(float amount) {
		if((this.health + amount) > this.maxHealth) {
			this.health = this.maxHealth;
		}
		this.health += amount;
	}
	public void takeDamage(int amount){
		this.health -= amount;
	}
	public void setHealth(float health) {
		this.health = health;
	}
	public float getHealth() {
		return this.health;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public int getDamage() {
		return this.damage;
	}
	
	/**
	 * 마나를 일정 값 만큼 추가합니다. 마나의 최대치는 maxMana를 넘을 수 없습니다
	 * @param amount 추가되는 마나의 양
	 */
	public void addMana(int amount) {
		if((this.mana + amount) > this.maxMana) {
			this.mana = this.maxMana;
		}
		this.mana += amount;
	}
	public void setMana(int amount) {
		this.mana = amount;
	}
	public int getMana() {
		return this.mana;
	}
	
	public Inventory getInventory() {
		return this.inventory;
	}
	
	
}
