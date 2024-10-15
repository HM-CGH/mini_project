package com.humanmedi.miniproject.item;

public class WeaponItem extends ItemStack{
	
	private int damage;

	public WeaponItem(Material material) {
		super(material);
		
		this.sortWeaponType(material);
	}
	
	
	private void sortWeaponType(Material material){
		switch(material) {
			case WOOD_SWORD:{
				this.setDamage(2);
			}
			case STONE_SWORD:{
				this.setDamage(4);
			}
			case IRON_SWORD:{
				this.setDamage(6);
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

}
