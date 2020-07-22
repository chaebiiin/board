package co.micol.board.db;


import java.util.*;

public class InputTest {
	Scanner sc = new Scanner(System.in);
	MemberDao dao = new MemberDao();
	List<MemberVo> list = new ArrayList<MemberVo>();
	MemberVo vo;

	public void menu() {
		boolean boolCheck = true;
		do { //do ~ while 다시 설명.
			System.out.println("1. 조 회 ");
			System.out.println("2. 입 력 ");
			System.out.println("3. 수 정 ");
			System.out.println("4. 삭 제 ");
			System.out.println("5. 종 료");
			System.out.println("=============================");
			System.out.println("원하는 번호를 선택하세요.");

			switch (sc.nextInt()) { //sc.nextInt()다시 설명 
			case 1:
				memberSelect();
				break;

			case 2:
				memberInput();
				break;

			case 3:
				memberUpdate();
				break;

			case 4:
				memberDelete();
				break;

			case 5:
				boolCheck = false;
				System.out.println("\n\n 작업이 종료 되었습니다.");
			break;
			}
		} while (boolCheck);
	}

	private void memberDelete() {
		boolean bool = true;
		System.out.println("삭제 할 회원 아이디를 입력하세요.");
		vo = new  MemberVo();
		vo.setId(sc.next());
		int n = dao.delete(vo);
		if(n != 0 ) {
			System.out.println("삭제 되었습니다.");
		}else {
			System.out.println("실패 되었습니다.");
		}
	}

	private void memberUpdate() { //입력해보기
		
		
	}

	private void memberInput() { //입력하기
		boolean bool = true;
		System.out.println("입력 할 회원 아아디를 입력하세요.");
		vo = new  MemberVo();
		vo.setId(sc.next());
	}

	private void memberSelect() {
		boolean bool = true;
		do {
			System.out.println("1. 전체회원 조회");
			System.out.println("2. 회원조회");
			System.out.println("3. 돌아가기");
			System.out.println("============================");
			System.out.println("작업번호를  선택하새요.");
			
			switch (sc.nextInt()) {
			case 1:
				list = dao.selectAllMember();
				System.out.println("*****전체회원 조회 ******");
				for (MemberVo member : list) {
					member.toString();
				}
				break;

			case 2:
				vo = new MemberVo();
				System.out.println("회원 아이디를 입력하세요> ");
				vo.setId(sc.next());
				vo = dao.select(vo);
				vo.toString();
				break;

			case 3:
				bool = false;
				break;
			}
		}while(bool);
	}
}