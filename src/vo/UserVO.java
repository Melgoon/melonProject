package vo;

public class UserVO {
	private String u_id; // 유저 아이디
	private String u_pw; // 유저 비밀번호
	private String u_name; // 유저 이름
	private String u_n_name; // 유저 닉네임
	private int u_ticket; // 유저 티켓
	
	public String getId() {
		return u_id;
	}
	public void setId(String id) {
		this.u_id = id;
	}
	public String getPassword() {
		return u_pw;
	}
	public void setPassword(String password) {
		this.u_pw = password;
	}
	public String getName() {
		return u_name;
	}
	public void setName(String name) {
		this.u_name = name;
	}
	public String get_n_Name(){
		return u_n_name;
	}
	public void set_n_Name(String n_name){
		this.u_n_name = n_name;
	}
	public int get_u_ticket(){
		return u_ticket;
	}
	public void set_u_ticket(int ticket){
		this.u_ticket = ticket;
	}
	private String name;
}
