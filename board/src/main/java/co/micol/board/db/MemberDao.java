package co.micol.board.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDao {
	// 무슨 역할을 하는 건지? 왜 따로 빼준건지? 
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "micol";
	private String password = "1234";
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;

	// 시퀄?? //이게 뭔지 상수 웅앵... 왜 이렇게 따로 빼준건지 다시 설명 듣기. (CRUD)
//접근제한자/ 상수(무조건 대문자로) /타입 / 상수명(변수명)/ 값
	private final String SELECT_MEMBER = "select * from member where id =?";
	private final String SELECT_MEMBER_ALL = "select * from member";
	private final String INSERT_MEMBER = "insert into member values(?,?,?,?)";
	private final String DELETE_MEMBER = "delete from member where id = ?";
	private final String UPDATE_MEMBER = "update member set password = ?, name = ?, tel = ? where id = ?";

	public MemberDao() { //DB연결하는 부분? 
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// id | pw | name | tel
	// hong | 1234 | 홍길동 | 010-1111-1111
//rs.next를 하면 id로 간다???? 
	public int sum(int a , int b) {
		return a+b;
	}
	
	public MemberVo select(MemberVo vo) { // 한 명의 멤버를 검색.

		try {
			psmt = conn.prepareStatement(SELECT_MEMBER);
			psmt.setString(1, vo.getId());
			rs = psmt.executeQuery(); // result set 객체를 통해서 받는다 ;
			if (rs.next()) { // 무슨 역할을 하는 건지 다시 설명 듣기.
				vo.setPassword(rs.getString("password")); //
				vo.setName(rs.getString("name"));
				vo.setTel(rs.getString("tel"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}
				//컬렉션
	public List<MemberVo> selectAllMember() {
		List<MemberVo> list = new ArrayList<MemberVo>();
		try {
			psmt = conn.prepareStatement(SELECT_MEMBER_ALL);
			rs = psmt.executeQuery();
			
			while (rs.next()) {
	  		// 클래스명 객체명  = 생성자()
				MemberVo vo = new MemberVo(); //초기화
				vo.setId(rs.getString("id"));
				vo.setPassword(rs.getString("password"));
				vo.setName(rs.getString("name"));
				vo.setTel(rs.getString("tel"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public int insert(MemberVo vo) { // insert
		int n = 0;
		try {
			psmt = conn.prepareStatement(INSERT_MEMBER);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getName());
			psmt.setString(3, vo.getPassword());
			psmt.setString(4, vo.getTel());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	public int update(MemberVo vo) { // update
		int n = 0;
		try {
			/*UPDATE_MEMBER => 
			 * update member
			 * set password = ?, name = ?, tel = ?
			 * where id = ?
			 * */
			psmt = conn.prepareStatement(UPDATE_MEMBER);
			psmt.setString(1, vo.getPassword());
			psmt.setString(2, vo.getName());
			psmt.setString(3, vo.getTel());
			psmt.setString(4, vo.getId());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	public int delete(MemberVo vo) { // delete
		int n = 0;
		try {
			psmt = conn.prepareStatement(DELETE_MEMBER);
			psmt.setString(1, vo.getId());
			n = psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return n;
	}
}
