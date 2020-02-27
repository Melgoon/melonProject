package controller;

import java.util.Scanner;

import data.Session;
import service.UserService;
import vo.UserVO;

public class Melon {

	public static void main(String[] args) {
		
		new Melon().start();

	}
	
	UserService userService = UserService.getInstance();
	
	private void start(){
		userService.main();
	}
}



/*

UserService userService = UserService.getInstance(); // 유저서비스란 객체에서 겟 인스턴스를 실행한 결과값을 가져온다.

private void start() {
	Scanner s = new Scanner(System.in); // 입력받는 스캐너
	
	int menu; // 메인 기능
	
	do{
		System.out.println("-------------메뉴---------------");
		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");
		System.out.println("3. 회원목록");
		System.out.println("0. 프로그램 종료");
		System.out.println("--------------------------------");
		System.out.print("메뉴에 해당하는 번호 입력>");
		
		menu = Integer.parseInt(s.nextLine()); // 입력받는다.
		
		switch(menu){
		case 1 : //회원가입
			userService.join();
			break;
		case 2 : // 로그인
			userService.login();
			break;
		case 3 : // 회원목록
			userService.userList();
			break;
		case 0 : // 프로그램 종료
			System.out.println("프로그램 종료");
			break;
		}
	}while(menu != 0); // 프로세스 종료
}

}
*/