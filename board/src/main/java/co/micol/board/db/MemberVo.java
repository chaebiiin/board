package co.micol.board.db;

public class MemberVo {
	private String id;
	private String password;
	private String name;
	private String tel;
	
	public MemberVo() {
		super();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String toString() { // 출력 해보기 위해 만든 메소드??? ㅎ0ㅎ! 현업에서는 잘 안씀 ...ㅎㅎ
		System.out.println("아이디:  " + getId());
		System.out.println("패스워드:  " + getPassword());
		System.out.println("이름:  " + getName());
		System.out.println("전화번호:  " + getTel());		
		
		return null; //??
	}
}
