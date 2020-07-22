package co.micol.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDao {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";;
	private String user = "micol";
	private String password = "1234";
	// 무슨 역할을 하는 건지? 
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	
	//시퀄????? //이게 뭔지 상수 웅앵...  왜 이렇게 따로 빼준건지 다시 설명 듣기. 
	private  final String SELECT_MEMBER = "select * from member where id =?";
	private final String SELECT_MEMBER_ALL =" select * from member";
	private final String INSERT_MEMBER = "insert into member values(?,?,?,?)";
	private final String DELETE_MEMBER = "delete from member where id = ?";
	private final String UPDATE_MEMBER = "update member set password = ?, name = ?, tel = ? where id = ?";
	
	
	
	public MemberDao() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// id   |  pw  |  name | tel
	// hong | 1234 |  홍길동  | 010-1111-1111
//rs.next를 하면 id로 간다???? 뭔소리야 시벌
	
	public MemberVo select(MemberVo vo) { // 한 명의 멤버를 검색.
		
		try {
			psmt = conn.prepareStatement(SELECT_MEMBER);
			psmt.setString(1, vo.getId());
			rs = psmt.executeQuery(); //result set 객체를 통해서 받는다 ;
			if (rs.next()) { // 무슨 역할을 하는 건지 다시 설명 듣기.
				vo.setPassword(rs.getString("password")); //vo객체에 password를 전달하는 역할??? 뭔소리여  이게 왜 튀어나온건지?????
				vo.setName(rs.getString("name"));
				vo.setTel(rs.getString("tel"));
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	public List<MemberVo> selectAllMember() {
		List<MemberVo> list = new ArrayList<MemberVo>();

		return list;
	}

	public int insert(MemberVo vo) { //insert;;
		int n;
		return 0;
	}
	public int update(MemberVo vo) { //update;;
		int n;
		return 0;
	}
	public int delete(MemberVo vo) { //delete
		int n;
		return 0;
	}
}
