package co.micol.board;

import co.micol.db.MemberDao;
import co.micol.db.MemberVo;

public class App {
	//실행하는 곳
	public static void main(String[] args) {
	MemberVo vo = new MemberVo(); // vo 객체 생성, 인스턴스 만드는 것
	MemberDao dao = new MemberDao(); //Dao 객체 생성
	vo.setId("kim");
	vo = dao.select(vo); // vo 타입????????????????????????????????????????????
	vo.toString();
//	System.out.println(vo.getName());
	}
	
}