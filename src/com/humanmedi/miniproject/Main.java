package com.humanmedi.miniproject;

import com.humanmedi.miniproject.entity.Player;

public class Main {
	public static Main instance = new Main();
	public static void main(String args[]) {
		
		GlobalDefine.player = new Player("플레이어");
		
		System.out.println("=======================");
		System.out.println("=======================");
		System.out.println("챗 게임에 오신것을 환영합니다!");
		System.out.println("=======================");
		System.out.println("=======================");
		System.out.println("1. 던전으로 들어간다.");
		System.out.println("2. 상태 점검");
		System.out.println("3. 게임 종료");
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
		System.out.println("야생의 몬스터가 나타났다!");
		// 몬스터 랜덤생성 로직 
		System.out.println("무엇을 할까?");
		System.out.println("1. 공격");
		System.out.println("2. 인벤토리");
		System.out.println("3. 도망친다");
		int dungeon_res = ConsoleHandler.instance.getInt(">");
		int while_res=100;
		
		// 몬스터 체력이 0 이하이면 while문 out.
		while(while_res>0) {
			System.out.println("현재 몬스터 체력 : " + while_res);
			if(dungeon_res==1) {
				System.out.println("어떤공격을 할까?");
				System.out.println("1. 일반공격");
				System.out.println("2. 스킬공격");
				int attack_res = ConsoleHandler.instance.getInt(">");
				if(attack_res==1) {
					instance.doGeneralAttack();
					// 몬스터 체력 빼기 
					while_res=while_res-10;
					
					// 몬스터의 공격 턴
					// 플레이어 체력 -
					// 플레이어의 체력이 0이 되면 게임 오바
					
				}else if(attack_res==2) {
					instance.doSkillAttack();
					while_res=while_res-15;
					// 몬스터의 공격 턴
					// 플레이어 체력 -
					
				}
			}else if(dungeon_res==2){
				instance.goInventory();
				// 인벤토리 확인 후 아이템 착용 또는 사용
				// 인벤토리 이벤트 발생시 턴 소모. 
				
			}else if(dungeon_res==3) {
				System.out.println("꽁지가 빠지게 도망갔다! ");
				System.out.println("*메인화면으로 돌아갑니다.");
				main(null);
				return;
			}
		}
		System.out.println("몬스터를 무찔렀다!!!");
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
		return;
	}
	
	// 스킬 확인
	public void goSkill() {
		System.out.println("스킬창 확인!");
		return;
	}
	
	// 일반공격실행
	public void doGeneralAttack() {
		System.out.println("일반공격실행!");
		// (플레이어의 공격력 + 무기 공격력)* 0~1(랜덤)
		return;
	}
	
	// 스킬공격실행
	public void doSkillAttack() {
		System.out.println("스킬공격실행!");
		// (플레이어의 공격력 + 무기 공격력) * 2 
		return;
	}
	
}