package Ch36.Domain.Dao;

import java.util.List;

import Ch36.Domain.Dto.BookDto;

public interface BookDao {

	// Workbench 에서 bookdb 생성 -> book 테이블 생성 -> BookDto 에 맞게 컬럼명 지정
	// INSERT
	boolean Insert(BookDto dto) throws Exception;

	// UPDATE
	boolean Update(String bookName, int bookCode) throws Exception;

	// DELETE
	// SELECTALL
	List<BookDto> SelectAll() throws Exception;

	// SELECTONE
	BookDto Select(int bookCode) throws Exception;

}