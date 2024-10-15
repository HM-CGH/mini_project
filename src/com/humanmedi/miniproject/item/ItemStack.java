package com.humanmedi.miniproject.item;

public class ItemStack {


    private Material material = null;

    public String name;





    public ItemStack(Material material){
        this.material = material;
    }


    






    public String getName(){
        return this.name;
    }
    
    public int getDamage(){
        return 10;
    }

    public Material getMaterial(){
        return this.material;
    }

}
