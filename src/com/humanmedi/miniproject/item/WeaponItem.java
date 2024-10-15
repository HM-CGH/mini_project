package com.humanmedi.miniproject.item;

import com.humanmedi.miniproject.elemental.Elemental;

public class WeaponItem extends ItemStack{
	
	private int damage;
	private Elemental elemental;

	public WeaponItem(Material material) {
		super(material);
		
		this.sortWeaponType(material);
	}
	
	
	private void sortWeaponType(Material material){
		switch(material) {
			case WOOD_SWORD:{
				this.setDamage(2);
				break;
			}
			case STONE_SWORD:{
				this.setDamage(4);
				break;
			}
			case IRON_SWORD:{
				this.setDamage(6);
				break;
			}
			case DIAMOND_SWORD:{
				this.setDamage(8);
				break;
			}
			default : {
				this.setDamage(0);
				break;
			}
		}
	}
	
	
	private void setDamage(int damage) {
		this.damage = damage;
	}
	public int getDamage() {
		return this.damage;
	}
	
	public void setElemental(Elemental elemental) {
		this.elemental = elemental;
	}
	public Elemental getElemental() {
		return this.elemental;
	}

}
