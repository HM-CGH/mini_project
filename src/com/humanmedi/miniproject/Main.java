package com.humanmedi.miniproject;

import com.humanmedi.miniproject.elemental.Elemental;
import com.humanmedi.miniproject.entity.Player;
import com.humanmedi.miniproject.item.WeaponItem;
import com.humanmedi.miniproject.stage.Dungeon;
import com.humanmedi.miniproject.stage.Monster;

public class Main {
	public static Main instance = new Main();
	public static void main(String args[]) {

		GlobalDefine.player = new Player("플레이어");
		
		String[] explain_main = {
			"챗 게임에 오신것을 환영합니다!"
		};
		String[] choices_main = {
			"던전으로 들어간다.",
			"상태 점검",
			"게임 종료"
		};

		ConsoleHandler.instance.displayText(explain_main, choices_main);
		
		// System.out.println("=======================");
		// System.out.println("챗 게임에 오신것을 환영합니다!");
		// System.out.println("=======================");
		// System.out.println("1. 던전으로 들어간다.");
		// System.out.println("2. 상태 점검");
		// System.out.println("3. 게임 종료");
		
		
		int main_res = ConsoleHandler.instance.getInt(">");
		while(true) {
			
			if(main_res==1) {
				instance.goDungeon();
				break;
			}else if(main_res==2) {
				instance.checkStatus();
				break;
			}else if(main_res==3) {
				System.out.println("게임을 종료합니다.");
				break;
			}else {
				System.out.println("잘못된 선택을 입력하셨습니다. 다시 입력해주세요.");
				main_res = ConsoleHandler.instance.getInt(">");
				
			}
		}
		
		
	}


	
	// 던전 진입 메서드
	public void goDungeon() {

		// 던전 생성
		Dungeon dungeon = new Dungeon();
		Monster monster = dungeon.spawnMonster();

		String[] explain_dungeon = {
			("야생의 " + monster.getType().name() + "가 나타났다!"),
			"무엇을 할까?"
		};
		String[] choices_dungeon = {
			"공격",
			"인벤토리",
			"도망친다"
		};


		
		// 몬스터 체력이 0 이하이면 while문 out.
		while(monster.getHealth()>0) {

			ConsoleHandler.instance.displayText(explain_dungeon, choices_dungeon);
			int dungeon_res = ConsoleHandler.instance.getInt(">");


			System.out.println("현재 몬스터 체력 : " + monster.getHealth());
			if(dungeon_res==1) {
				//🔪공격
				System.out.println("어떤공격을 할까?");
				System.out.println("1. 일반공격");
				System.out.println("2. 스킬공격");
				int attack_res = ConsoleHandler.instance.getInt(">");

				WeaponItem item = GlobalDefine.player.getInventory().getMainHand();
				int deal = GlobalDefine.player.getDamage();
				if(item != null){
					deal += item.getDamage();
				}
				if(attack_res==1) {
					
					instance.doGeneralAttack(monster, deal);
					// 몬스터 체력 빼기 

					
					// 몬스터의 공격 턴
					// 플레이어 체력 -
					// 플레이어의 체력이 0이 되면 게임 오바
					
				}else if(attack_res==2) {

					System.out.println("어떤 타입의 스킬을 쓸까?");
					System.out.println("1. 불");
					System.out.println("2. 물");
					System.out.println("3. 나무");

					int skill_type_res = ConsoleHandler.instance.getInt(">");

					Elemental skill_type = null;

					if(skill_type_res == 1){
						skill_type = Elemental.FIRE;
					}else if(skill_type_res == 2){
						skill_type = Elemental.WATER;
					}else if(skill_type_res == 3){
						skill_type = Elemental.WOOD;
					}
					instance.doSkillAttack(monster, deal, skill_type);
					// 몬스터의 공격, 플레이어 체력 변동
					
					
				}
			}else if(dungeon_res==2){
				//💼인벤토리
				instance.goInventory();

				System.out.println("어떤 아이템을 사용/착용 하시겠습니까? ");
				int selected_index_res = ConsoleHandler.instance.getInt(">");

				try{
					GlobalDefine.player.getInventory().takeWeapon(selected_index_res);
				}catch(Exception e){
					//System.out.println(e.getLocalizedMessage());
				}
				// 인벤토리 확인 후 아이템 착용 또는 사용
				// 인벤토리 이벤트 발생시 턴 소모. 
				
			}else if(dungeon_res==3) {
				//👢도망친다
				System.out.println("꽁지가 빠지게 도망갔다! ");
				System.out.println("*메인화면으로 돌아갑니다.");
				main(null);
				return;
			}
			// 몬스터 공격
			if(monster.isActable()){
				GlobalDefine.player.takeDamage(monster.getPower());
				System.out.println(monster.getPower() + "의 데미지를 받았다!");
				System.out.println("현재 체력 : " + GlobalDefine.player.getHealth());
				if(GlobalDefine.player.getHealth() < 1){
	
					System.out.println("당신은 죽었습니다.");
	
					return;
				}
			}
		
		}
		System.out.println("몬스터를 무찔렀다!!!");

		WeaponItem dropped_weapon = dungeon.dropWeapon(Elemental.getElemental());
		try{
			GlobalDefine.player.getInventory().addItem(dropped_weapon);
		}catch(Exception e){
			//인벤토리가 꽉 찼을 때
			System.out.println("인벤토리가 꽉 차 있습니다. 소지한 아이템이 랜덤으로 사라집니다. ");
			GlobalDefine.player.getInventory().setItem((int)(Math.random()*10), dropped_weapon);
		}

		System.out.println("이제 무엇을 할까?");
		System.out.println("1. 다음 던전으로 간다");
		System.out.println("2. 던전에서 나간다");
		int next_dungeon = ConsoleHandler.instance.getInt(">");
		if(next_dungeon==1) {
			System.out.println("다음 단계로 내려갑니다.");
			instance.goDungeon();
		}else if(next_dungeon==2) {
			System.out.println("*메인화면으로 돌아갑니다.");
			main(null);
		}
	}
	
	// 상태 점검
	public void checkStatus() {
		System.out.println("무엇을 확인할까?");
		System.out.println("1. 스킬");
		System.out.println("2. 인벤토리");
		int status_res = ConsoleHandler.instance.getInt(">");
		if(status_res == 1){
			instance.goSkill();
		}else if(status_res==2) {
			instance.goInventory();
		}
		
		return;
	}
	
	// 인벤토리 확인
	public void goInventory() {
		System.out.println("인벤토리창 확인!");

		GlobalDefine.player.getInventory().showInventory();
		return;
	}
	
	// 스킬 확인
	public void goSkill() {
		System.out.println("스킬창 확인!");
		return;
	}
	
	// 일반공격실행
	public void doGeneralAttack(Monster target, int damage) {
		System.out.println("일반공격실행!");

		target.takeDamage(damage);
		// (플레이어의 공격력 + 무기 공격력)* 0~1(랜덤)
		return;
	}
	
	// 스킬공격실행
	public void doSkillAttack(Monster target, int damage, Elemental skill_type) {
		System.out.println("스킬공격실행!");

		target.takeSkillDamage(damage, skill_type);
		// (플레이어의 공격력 + 무기 공격력) * 2 
		return;
	}
	
}