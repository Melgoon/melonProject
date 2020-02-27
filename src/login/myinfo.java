package login;
//6. 로그인 시 세션에 로그인 정보 담기 7.노래 검색 기능 8.내정보

public class myinfo {
	String u_id;
	String u_name;
	String ranking;
	String u_pw;
	boolean Purchase;
	String Ticket[];
	int coupon;
	void menuinfo(){ 
		System.out.println("--------------내 정보-----------------");
		System.out.println(" 내 아이디 : " + u_id);
		System.out.println(" 내 닉네임 : " + u_name );
		System.out.println(" 1.이용권 구매 : " );
		System.out.println(" 2.비밀번호 변경 " );
		System.out.println(" 3.닉네임 변경 ");
		System.out.println(" 1. 구매정보 2. 메인 3. 로그아웃");
		System.out.println("-------------------------------------");
	}
	void Ticket(){
		System.out.println("-------------------------------");
		System.out.println("보유중인 이용권 : " + Ticket ); // 보유중인 이용권 배열에서 표시
		System.out.println("보유중인 쿠폰 : " + coupon ); // 쿠폰 갯수 표시
	}
	
	void menu(){
		System.out.println("국내 최다 4000만곡 보유, No.1 뮤직플랫폼 멜론! 실시간 차트부터 나를 아는 똑똑한 음악추천까지!");
		System.out.println("-----------------------------------------------------------------------");
		System.out.println(u_id + "님 어서오세요.");
		System.out.println(" 1. 내 정보	2.이용권 구매	3.노래 검색  4. 로그아웃");
	}
	
	
	void login(){
		
	}

}
