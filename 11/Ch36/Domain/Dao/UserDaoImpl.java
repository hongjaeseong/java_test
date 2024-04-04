package Ch36.Domain.Dao;

import Ch36.Domain.Dto.UserDto;

public class UserDaoImpl extends CommonDao implements UserDao  {
	// 싱글톤 패턴 (객체 생성을 단일화 시킴)	getInstance을 통해서만 객체 생성 가능
	private static UserDao instance;
	public static UserDao getInstance() throws Exception {
		if(instance == null)
			instance = new UserDaoImpl();
		return instance;
	}
	
	private UserDaoImpl() throws Exception {					// UserDao 생성자
		System.out.println("[DAO] UserDaoImpl's INIT..." + conn);
	}
	
	// INSERT (회원가입)
	@Override
	public boolean Insert(UserDto dto) throws Exception {		// 동일한 username이 insert 시 예외 처리
		pstmt = conn.prepareStatement("Insert into user values(?,?,?,?)");
		pstmt.setString(1, dto.getUsername());
		pstmt.setString(2, dto.getPassword());
		pstmt.setString(3, dto.getRole());
		pstmt.setBoolean(4, false);
		int result = pstmt.executeUpdate();	// 여기 확인!!!!!!!!!!!!!!!
		freeConnection(conn,pstmt);
		return result > 0;		// 수정된 것이 있다면 true 값 반환
	}
	
	// UPDATE
	
	// DELETE
	
	// SELECTALL
	
	// SELECT
	@Override
	public UserDto Select(String username) throws Exception{
		pstmt = conn.prepareStatement("select * from user where username = ?");
		pstmt.setString(1, username);
		rs = pstmt.executeQuery();
		UserDto dto = null;
		if(rs!=null) {
			if(rs.next()) {
				dto = new UserDto();
				dto.setUsername(username);
				dto.setPassword(rs.getString("password"));
				dto.setRole(rs.getString("role"));
				dto.setIslocked(rs.getBoolean("islocked"));
			}
		}
		return dto;
	}
	
	
}
