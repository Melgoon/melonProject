package login;

import java.util.Scanner;

public class login {
	Scanner s = new Scanner(System.in);
	myinfo p = new myinfo();
	
	void melon(){
		System.out.println("국내 최다 4000만곡 보유, No.1 뮤직플랫폼 멜론! 실시간 차트부터 나를 아는 똑똑한 음악추천까지!");
		System.out.println("-----------------------------------------------------------------------");
		System.out.println(" 1. 로그인	2.회원가입	3.노래 검색 	4.인기 차트");
		String so = s.nextLine();
		if(so.equals("1")){
			login();
	      }else if(so.equals("2")){
	    	
	      }else if(so.equals("3")){
	    	  System.out.println("로그아웃하였습니다.");
	      }
	}
	void login(){
		System.out.println("-------------로그인--------------");
		System.out.print(" ID : ");
		p.u_id = s.nextLine();
		System.out.print(" PW : ");
		p.u_pw = s.nextLine();
		System.out.println("--------------------------------");
		menu();
	}
	
	void menu(){
		p.menu();
		String so = s.nextLine();
		if(so.equals("1")){
			
	      }else if(so.equals("2")){
	    	
	      }else if(so.equals("3")){
	    	  System.out.println("로그아웃하였습니다.");
	      }
	}
	
		
	}


/*do{
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

}*/
