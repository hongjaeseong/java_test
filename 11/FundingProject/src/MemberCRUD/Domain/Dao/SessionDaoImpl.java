package MemberCRUD.Domain.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import MemberCRUD.Domain.Dto.SessionDto;

public class SessionDaoImpl {
	// DB 연결 기본 속성
	private String url = "jdbc:mysql://localhost:3306/memberdb";
	private String id = "root";
	private String pw = "1234";
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public SessionDaoImpl() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(url,id,pw);
		System.out.println("[DAO] SessionDaoImpl's INIT DB Connected...");
	}
	
	// SessionDto CRUD
	// SELECT (sessionId)
	public SessionDto Select(int sessionId) throws Exception {
		pstmt = conn.prepareStatement("select * from session where sessionId = ?");
		pstmt.setInt(1, sessionId);
		rs = pstmt.executeQuery();
		SessionDto dto = null;
		if(rs != null) {
			rs.next();
			dto = new SessionDto();
			dto.setUsername( rs.getString("username") );
			dto.setRole( rs.getString("role") );
			dto.setSessionId( rs.getInt("sessionId"));
		}
		rs.close();
		pstmt.close();
		return dto;
	}
	
	// SELECT (username)
	public SessionDto Select(String username) throws Exception {
		pstmt = conn.prepareStatement("select * from session where username = ?");
		pstmt.setString(1, username);
		rs = pstmt.executeQuery();
		SessionDto dto = null;
		if(rs != null) {
			rs.next();
			dto = new SessionDto();
			dto.setUsername( rs.getString("username") );
			dto.setRole( rs.getString("role") );
			dto.setSessionId( rs.getInt("sessionId") );
		}
		rs.close();
		pstmt.close();
		return dto;
	}
	
	// SELECTALL
	public List<SessionDto> SelectAll() throws Exception {
		pstmt = conn.prepareStatement("select * from session");
		rs = pstmt.executeQuery();
		List<SessionDto> list = new ArrayList();
		
		SessionDto dto = null;
		if(rs != null)
		{
			while(rs.next()) {
				dto = new SessionDto();
				dto.setUsername(rs.getString("username"));
				dto.setSessionId(rs.getInt("sessionId"));
				dto.setRole(rs.getString("role"));
				list.add(dto);
			}
		}
		rs.close();
		pstmt.close();
		return list;
	}
	
	// INSERT
	public boolean Insert(SessionDto sessionDto) throws Exception {
		pstmt = conn.prepareStatement("insert into session values(null,?,?)");
		pstmt.setString(1, sessionDto.getUsername());
		pstmt.setString(2, sessionDto.getRole());
		int result = pstmt.executeUpdate();
		
		pstmt.close();
		return result > 0;
	}
	
	// UPDATE (SessionDto 수정은 필요없음)
	// DELETE
	public boolean Delete(int sessionId) throws Exception {
		pstmt = conn.prepareStatement("delete from session where sessionId = ?");
		pstmt.setInt(1, sessionId);
		int result = pstmt.executeUpdate();
		
		pstmt.close();
		return result > 0;
	}
	
}
