package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import vo.UserVO;
import dao.UserDao;
import data.Session;

public class UserService {
	
	private static UserService instance; 
	
	private UserService(){}

	public static UserService getInstance(){
		if(instance == null){
			instance = new UserService();
		}
		return instance;
	}
	
	UserDao userDao = UserDao.getInstance();
	
	public void main(){ // 메인 화면 
		Scanner s = new Scanner(System.in);
		int menu; // 메인 기능
		do{
			System.out.println("-----------------------------------------------------------------------");
		System.out.println("국내 최다 4000만곡 보유, No.1 뮤직플랫폼 멜론! 실시간 차트부터 나를 아는 똑똑한 음악추천까지!");
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("1.로그인	 2.회원가입	3.노래 검색	4.차트보기	5.게시판"  + "\n" +	"0.종료");
		System.out.println("-----------------------------------------------------------------------");
		System.out.print("메뉴에 해당하는 번호를 입력해주세요. >");
		menu = Integer.parseInt(s.nextLine());
		
		
		
		switch(menu){
		case 1 : //로그인
			login();
			if(Session.LoginUser == null ){ //세션의 값을 비교해서 로그인,로그인불가 처리
				break;
			}else{
				loginmenu();
			}
			break;
		case 2 : // 회원가입
			join();
			break;
		/*case 3 : // 노래 검색
			break;
		case 4 : // 차트 보기
			break;
		case 5 : // 게시판
			
			break;
			*/
		case 0 : // 프로그램 종료
			System.out.println("프로그램 종료");
			break;
		}
		
		}while(menu != 0);
	}
	//일반 사용자 로그인 화면
	void loginmenu(){ 
		Scanner s = new Scanner(System.in);
		int menu;
		do{
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("국내 최다 4000만곡 보유, No.1 뮤직플랫폼 멜론! 실시간 차트부터 나를 아는 똑똑한 음악추천까지!");
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("1.내 정보		2.이용권 구매		3.노래 검색		4.차트보기 " + 
		"\n" + "5.게시판		0.로그아웃");
		System.out.println("-----------------------------------------------------------------------");
		System.out.print("메뉴에 해당하는 번호를 입력해주세요. >");
		menu = Integer.parseInt(s.nextLine());
		switch(menu){
		case 1: // 내정보 화면
			userinfo();
			break;
		case 0: // 프로그램 종료
			System.out.println("로그아웃");
			break;
		}
		}while(menu != 0);
		}
	
	
	//회원가입
	public void  join(){
		Scanner s = new Scanner(System.in);
		
		String id = null; //널값으로 초기화하고 선언
		UserVO idCheck = null; //널값으로 초기화하고 선언
	do{
		System.out.println("아이디 : ");
		id = s.nextLine(); // 값 삽입
		
		HashMap<String, String> param = new HashMap<>();
		param.put("ID",id);
		idCheck = userDao.selectUser(param); // 저장된 값과 비교 
		
		if(idCheck != null){ //아이디가 중복된 값이 있을 때
			System.out.println("사용할 수 없는 아이디 입니다.");
		}
	}while(idCheck != null);
	
		System.out.println("비밀번호: ");
		String password = s.nextLine();
		System.out.println("닉네임  : ");
		String name = s.nextLine();
		
		UserVO user = new UserVO();
		
		user.setId(id);
		user.setPassword(password);
		user.setName(name);
		
		userDao.insertUser(user);
		System.out.println("가입 되셨습니다.");
	}
	
	//로그인
	public void login(){
		Scanner s = new Scanner(System.in);
		
		System.out.println("아이디 : ");
		String id = s.nextLine();
		System.out.println("비밀번호 : " );
		String password = s.nextLine();
		
		HashMap<String, String> param = new HashMap<>(); // 
		param.put("ID", id);
		param.put("PASSWORD", password);
		
		UserVO user = userDao.selectUser(param);
		
		if(user == null){ //user가 null일 때
			System.out.println("아이디 혹은 비밀번호를 잘못 입력하셨습니다.");
		}else{ // user가 null이 아니고 id와 password가 같으면 로그인 처리
			System.out.println("로그인 성공!");
			System.out.println(user.getName() + "님 환영합니다.");
			Session.LoginUser = user;
		}
		
	}
	
	
	// 일반 사용자 정보 화면
	public void userinfo(){ 
		Scanner s = new Scanner(System.in);
		int menu;
		UserVO user = Session.LoginUser;
		do{
		System.out.println("--------------내 정보-----------------");
		System.out.println(" 내 아이디 : " + user.getId()); // 세션에 있는 아이디를 가지고 온다.
		System.out.println(" 내 닉네임 : " + user.getName()); // 세션에 있는 닉네임을 가져온다.
		System.out.println(" 1.이용권 구매 여부 " + "\n" + "2.비밀번호 변경" );
		System.out.println(" 3.닉네임 변경 " + "\n " + " 4.회원 탈퇴 ");
		System.out.println(" 1.이용권 구매 여부 2.비밀번호 변경 3. 닉네임변경 4. 회원탈퇴 "+ "\n" +" 0. 메인");
		System.out.println("-------------------------------------");
		menu = Integer.parseInt(s.nextLine());
		switch(menu){
		case 1:
			
		case 2:
			PWchange();
			break;
		case 3:
			NMchange();
			break;
		case 4:
			break;
		case 0:
			break;
		}
		}while(menu != 0);
		}
	
	//비밀번호 변경
	public void PWchange(){
		Scanner s = new Scanner(System.in);
		String password = null;
		UserVO pwCheck = null;
		
		do{
			System.out.println("기존 비밀번호를 입력해주세요."); 
			password = s.nextLine();
			
			HashMap<String, String> param = new HashMap<>();
			param.put("PASSWORD",password);
			pwCheck = userDao.selectUser(param); // 저장된 값과 비교 
			
			if(pwCheck != null){
				System.out.println("변경할 비밀번호를 입력해주세요.");
				password = s.nextLine();
				
				Session.LoginUser.setPassword(password);
				System.out.println("비밀번호가 변경되었습니다.");
				main();
			}else{
				System.out.println("비밀번호가 틀립니다.");
			}
		}while(pwCheck != null);
	}
	
	//닉네임 변경
			public void NMchange(){
				Scanner s = new Scanner(System.in);
				String name = null;
				UserVO nmCheck = null;
				
				do{
					System.out.println("변경할 닉네임 이름을 입력해주세요.");
					name = s.nextLine();
					
					HashMap<String, String> param = new HashMap<>();
					param.put("NAME",name);
					nmCheck = userDao.selectUser(param); // 저장된 값과 비교 
					
					if(nmCheck != null){ //닉네임이 중복되었을 때
						System.out.println("중복된 닉네임입니다.");
					}
					else{
						Session.LoginUser.setName(name);
						System.out.println("닉네임이 변경되었습니다.");
					}
				}while(nmCheck != null);
				
				}
	
	}


	//회원목록
	/*public void userList(){
		ArrayList<UserVO> userList = userDao.selectUserList();
		
		System.out.println("----------------------------------");
		System.out.println("번호\t아이디\t이름");
		System.out.println("----------------------------------");
		
		for(int i = userList.size() -1; 0 <= i; i--){
			UserVO user = userList.get(i);
			System.out.println(i + 1+ "\t" + user.getId() + "\t" + user.getName());
		}
		System.out.println("-----------------------------------");
	}*/



