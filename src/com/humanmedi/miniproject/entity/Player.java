package com.humanmedi.miniproject.entity;

import com.humanmedi.miniproject.inventory.Inventory;

public class Player implements Entity{
	private String name;
	private float health;
	private int damage;
	
	private Inventory inventory;
	
	
	public Player() {
		this.inventory = new Inventory();
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
	
	public Inventory getInventory() {
		return this.inventory;
	}
	
	
}
