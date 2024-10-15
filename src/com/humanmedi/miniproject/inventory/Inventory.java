package com.humanmedi.miniproject.inventory;

import com.humanmedi.miniproject.item.ItemStack;
import com.humanmedi.miniproject.item.WeaponItem;

/**
 * 인벤토리 / 플레이어는 자동으로 인벤토리를 가집니다
 */
public class Inventory {
	private int _size = 10;
    private ItemStack[] _item_slot = new ItemStack[this._size];
    private WeaponItem _main_hand = null;
    
    
    /**
     * 접근하려는 인벤토리 위치가 유효한지 검사하는 메서드
     * @param index 인벤토리 위치
     * @return 위치가 유효하다면 true
     */
    private boolean isValidRange(int index) {
    	if((index > 0) && (index < this._size)) {
    		return true;
    	}else {
    		return false;
    	}
    }
    
    
    
    /**
     * 인벤토리 위치에 존재하는 아이템을 삭제하는 메서드
     * @param index 삭제하려는 아이템의 인벤토리 위치
     */
    public void removeItem(int index) {
    	if(this.isValidRange(index)) {
    		_item_slot[index] = null;
    	}
    }
    /**
     * 특정 인벤토리 위치에 아이템을 집어넣는 메서드
     * 이미 아이템이 존재할 경우 아이템을 집어넣을 수 없습니다
     * @param index 아이템이 들어갈 인벤토리 위치
     * @param item 집어넣으려는 아이템
     */
    public void setItem(int index, ItemStack item) {
    	if(!this.isValidRange(index)) {
    		return;
    	}
    	if(_item_slot[index] != null) {
    		throw new Error("slot is not empty");
    	}
    	
    	
    	_item_slot[index] = item;
    }
    /**
     * 인벤토리의 빈칸에 아이템을 집어넣는 메서드
     * @param item 집어넣으려는 아이템
     */
    public void addItem(ItemStack item) {
    	
    	boolean isFilled = false;
    	
    	for(int i = 0; i < this._size; i++) {
    		if(_item_slot[i] == null) {
    			_item_slot[i] = item;
    			isFilled = true;
    			break;
    		}
    	}
    	
    	if(!isFilled) {
    		throw new Error("inventory is not empty");
    	}
    }
    
    /**
     * 인벤토리 특정 위치의 아이템을 불러오는 메서드
     * 아이템이 없는 경우 null이 반환된다 
     * @param index 불러오려는 위치
     * @return 아이템
     */
    public ItemStack getItem(int index) {
    	if(!this.isValidRange(index)) {
    		throw new Error("Out Of Range");
    	}else {
    		if(_item_slot[index] == null) {
    			return null;
    		}else {
    			return _item_slot[index];
    		}
    	}
    }


    public void takeWeapon(int index) {
    	
    	if(!(_item_slot[index] instanceof WeaponItem)) {
    		throw new Error("무기만 장착할 수 있습니다");
    	}
    	
    	this._main_hand = (WeaponItem) _item_slot[index];
    }
    
    public void takeOffWeapon() {
    	try {
    		this.addItem(this._main_hand);
    		this._main_hand = null;
    	}catch(Exception e) {
    		throw e;
    	}
    }


    public WeaponItem getMainHand() {
    	return this._main_hand;
    }

}
