package com.humanmedi.miniproject;

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
}

