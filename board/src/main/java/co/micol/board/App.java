package co.micol.board;

import java.util.ArrayList;
import java.util.List;

import co.micol.board.db.MemberDao;
import co.micol.board.db.MemberVo;

public class App {
	// 실행하는 곳
	public static void main(String[] args) {
		MemberVo vo = new MemberVo(); // vo 객체 생성, 인스턴스 만드는 것
		MemberDao dao = new MemberDao(); // Dao 객체 생성

		vo.setId("kim");
		vo = dao.select(vo); // vo 타입????????????????????????????????????????????
		vo.toString();

		List<MemberVo> list = new ArrayList<MemberVo>();
		list = dao.selectAllMember();

		for (MemberVo member : list) {
			member.toString();
		}

		// insert 실행
		vo = new MemberVo(); // 초기화
		// 값을 대입.
//		vo.setId("soyee");
//		vo.setPassword("1121");
//		vo.setName("장소진");
//		vo.setTel("010-0620-1121");

//		int n = dao.insert(vo);
//		if (n != 0) {
//			System.out.println("정상적 입력");
//		} else {
//			System.out.println("입력 실패");
//		}
//		
		//update
//		vo = new MemberVo(); // 
//		vo.setPassword("1122");
//		vo.setName("장소이");
//		vo.setTel("010-0628-1121");
//		vo.setId("soyee");
//		
//		int m = dao.update(vo);
//		if (m != 0) {
//			System.out.println("정상적 업데이트");
//		} else {
//			System.out.println("업데이트 실패");
//		}
		
		//delete 실행
		vo = new MemberVo();
		vo.setId("soyee");
		dao.delete(vo);
		
		int o = dao.update(vo);
		if (o != 0) {
			System.out.println("정상적 삭제");
		} else {
			System.out.println("삭제 실패");
		}
	}
}
