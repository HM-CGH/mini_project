package com.humanmedi.miniproject;

import java.util.List;
import java.util.Scanner;
 
/**
 * 입력 제어
 */
public class ConsoleHandler {

    private Scanner scanner = new Scanner(System.in);

    public static ConsoleHandler instance = new ConsoleHandler(); 

    private ConsoleHandler(){}
    
    public int getInt(String str) {
		int no = 0;
		
		while(true) {
			try {
				System.out.println(str);
				no = scanner.nextInt();
				
				return no;
			} catch (Exception e) {
				System.out.println("오류가 발생했습니다. /" + e.getMessage());
				System.out.println("숫자만 입력해주세요. ");
				scanner.nextLine();
				System.out.println("================================================");
				System.out.println("================================================");
			}
		}
	}
	public void displayText(String[] explain, String[] choices){
		System.out.println("=======================");
		for(String text:explain){
			System.out.println(text);
		}
		System.out.println("=======================");

		for(int i = 0; i < choices.length; i++){
			System.out.printf("%d. %s\n", i+1, choices[i]);
		}
	}
	public void displayText(String[] explain, List<String> choices){
		System.out.println("=======================");
		for(String text:explain){
			System.out.println(text);
		}
		System.out.println("=======================");

		for(int i = 0; i < choices.size(); i++){
			System.out.printf("%d. %s\n", i+1, choices.get(i));
		}
	}
}

