package com.humanmedi.miniproject.item;

public class ItemStack {


    private Material material = null;


    public ItemStack(Material material){
        this.material = material;
    }


    public void setMaterial(Material material) {
    	this.material = material;
    }
    public Material getMaterial(){
        return this.material;
    }

}
