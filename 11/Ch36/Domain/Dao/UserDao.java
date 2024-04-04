package Ch36.Domain.Dao;

import Ch36.Domain.Dto.UserDto;

public interface UserDao {

	// INSERT (회원가입)
	boolean Insert(UserDto dto) throws Exception;

	// SELECT
	UserDto Select(String username) throws Exception;

}