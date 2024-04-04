package Ch36.Domain.Dao;

import java.util.ArrayList;
import java.util.List;

import Ch36.Domain.Dto.SessionDto;

public class SessionDaoImpl extends CommonDao implements SessionDao {
	// 싱글톤 패턴 (객체 생성을 단일화 시킴)	getInstance을 통해서만 객체 생성 가능
	private static SessionDao instance;
	public static SessionDao getInstance() throws Exception {
		if(instance == null)
			instance = new SessionDaoImpl();
		return instance;
	}
	
	private SessionDaoImpl() throws Exception {
		System.out.println("[DAO] SessionDaoImpl's INIT..." + conn);
	}

	// Session 용
	@Override
	public boolean Insert(SessionDto sessionDto) throws Exception { // sessionDto에 추가하는 메소드 (로그인 상태 정보 확인)
		pstmt = conn.prepareStatement("Insert into session values(null,?,?)");
		pstmt.setString(1, sessionDto.getUsername());
		pstmt.setString(2, sessionDto.getRole());

		return pstmt.executeUpdate() > 0;
	}
	
	@Override
	public SessionDto Select(int sessionId) throws Exception {
		pstmt = conn.prepareStatement("select * from session where id = ?");
		pstmt.setInt(1, sessionId);
		rs = pstmt.executeQuery();
		SessionDto dto = null;
		if(rs!=null) {
			rs.next();
			dto = new SessionDto();
			dto.setUsername(rs.getString("username"));
			dto.setRole(rs.getString("role"));
			dto.setSessionId(rs.getInt("id"));
			
		}
		return dto;
	}

	@Override
	public SessionDto Select(String username) throws Exception {
		pstmt = conn.prepareStatement("select * from session where username = ?");
		pstmt.setString(1, username);
		rs = pstmt.executeQuery();
		SessionDto dto = null;
		if(rs!=null) {
			rs.next();
			dto = new SessionDto();
			dto.setUsername(rs.getString("username"));
			dto.setRole(rs.getString("role"));
			dto.setSessionId(rs.getInt("id"));
			
		}
		return dto;
	}

	@Override
	public boolean Delete(int sessionId) throws Exception {
		pstmt = conn.prepareStatement("delete from session where id = ?");
		pstmt.setInt(1, sessionId);
		int result = pstmt.executeUpdate();
		pstmt.close();
		return result > 0;
	}
	
	// SELECTALL
	@Override
	public List<SessionDto> SelectAll() throws Exception {
		pstmt = conn.prepareStatement("select * from session");
		rs = pstmt.executeQuery();
		List<SessionDto> list = new ArrayList();
		
		SessionDto dto = null;
		if (rs != null) 
		{
			while(rs.next()) {		// 행의 개수만큼 반복
				dto = new SessionDto();
				dto.setUsername(rs.getString("username"));
				dto.setSessionId(rs.getInt("id"));
				dto.setRole(rs.getString("role"));
				list.add(dto);
			}
		}
		rs.close();
		pstmt.close();
		return list;
	}
}
