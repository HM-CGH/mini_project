package com.humanmedi.miniproject;

public class Main {
	public static Main instance = new Main();
	public static void main(String args[]) {
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
			}else if(main_res==2) {
				instance.checkStatus();
				return;
			}else if(main_res==3) {
				System.out.println("게임을 종료합니다.");
				return;
			}else {
				System.out.println("잘못된 선택을 입력하셨습니다. 다시 입력해주세요.");
				main_res = ConsoleHandler.instance.getInt(">");
				
			}
		}


		
	}
	
	public void goDungeon() {
		System.out.println("야생의 몬스터가 나타났다!");
		// 몬스터 랜덤생성 로직 
		System.out.println("무엇을 할까?");
		System.out.println("1. 공격");
		System.out.println("2. 인벤토리");
		System.out.println("3. 도망친다");
		int dungeon_res = ConsoleHandler.instance.getInt(">");
		int while_res=0;
		while(while_res==0) {
			if(dungeon_res==1) {
				System.out.println("어떤공격을 할까?");
				System.out.println("1. 일반공격");
				System.out.println("2. 스킬공격");
				int attack_res = ConsoleHandler.instance.getInt(">");
				if(attack_res==1) {
					instance.doGeneralAttack();
					while_res=1;
					
				}else if(attack_res==2) {
					instance.doSkillAttack();
					break;
				}
			}else if(dungeon_res==2){
				
			}else if(dungeon_res==3) {
				System.out.println("꽁지가 빠지게 도망갔다! ");
				System.out.println("*메인화면으로 돌아갑니다.");
				main(null);
				return;
			}
		}
	}
	
	public void checkStatus() {
		System.out.println("상태점검메서드");
		return;
	}
	
	public void doGeneralAttack() {
		System.out.println("일반공격실행!");
		return;
	}
	
	public void doSkillAttack() {
		System.out.println("스킬공격실행!");
		return;
	}
	
}
