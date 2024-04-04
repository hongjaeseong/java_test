package Ch36.Domain.Dao;

import java.util.ArrayList;
import java.util.List;

import Ch36.Domain.Dto.BookDto;

public class BookDaoImpl extends CommonDao implements BookDao{
	
	// 싱글톤 패턴 (객체 생성을 단일화 시킴)
	private static BookDao instance;
	public static BookDao getInstance() throws Exception {
		if(instance == null)
			instance = new BookDaoImpl();
		return instance;
	}
	private BookDaoImpl() throws Exception {
		System.out.println("[DAO] BookDaoImpl's INIT..." + conn);	// 출력
		
	}
	// Workbench 에서 bookdb 생성 -> book 테이블 생성 -> BookDto 에 맞게 컬럼명 지정
	// INSERT
	@Override
	public boolean Insert(BookDto dto) throws Exception {		// db에 insert 하는 메소드 정의
		pstmt = conn.prepareStatement("insert into book values(?,?,?,?)");	// sql문 작성
		pstmt.setInt(1, dto.getBookCode());
		pstmt.setString(2, dto.getBookName());
		pstmt.setString(3, dto.getPublisher());
		pstmt.setString(4, dto.getIsbn());
		int result = pstmt.executeUpdate();		// 변경된 개수 반환 후 result에 대입
		
		freeConnection(pstmt);		// 자원 제거 함수
		return result>0;	// 변경된 것이 1개라도 잇다면 true 반환
	}
	// UPDATE
	@Override
	public boolean Update(String bookName,int bookCode) throws Exception {
		pstmt = conn.prepareStatement("update book set BookName=? where BookCode=?");
		pstmt.setString(1, bookName);
		pstmt.setInt(2, bookCode);
		int result = pstmt.executeUpdate();
		freeConnection(pstmt);
		return result>0;
	}
	// DELETE
	// SELECTALL
	@Override
	public List<BookDto> SelectAll() throws Exception {
		pstmt = conn.prepareStatement("select * from book");
		rs = pstmt.executeQuery();
		List<BookDto> list = new ArrayList();
		
		BookDto dto = null;
		if (rs != null) {
			while(rs.next()) {		// 행의 개수만큼 반복
				dto = new BookDto();
				dto.setBookCode(rs.getInt("bookCode"));
				dto.setBookName(rs.getString("bookName"));
				dto.setPublisher(rs.getString("publisher"));
				dto.setIsbn(rs.getString("isbn"));
				list.add(dto);
			}
		}
		freeConnection(pstmt,rs);
		return list;
	}
	// SELECTONE
	@Override
	public BookDto Select(int bookCode) throws Exception {
		pstmt = conn.prepareStatement("select * from book where bookCode=?");
		pstmt.setInt(1, bookCode);
		rs = pstmt.executeQuery();
		
		BookDto dto = null;
		if (rs != null) {
			rs.next();		// 한 행만 SELECT 하기에 반복문 필요없음
			dto = new BookDto();
			dto.setBookCode(rs.getInt("bookCode"));
			dto.setBookName(rs.getString("bookName"));
			dto.setPublisher(rs.getString("publisher"));
			dto.setIsbn(rs.getString("isbn"));	
		}
		freeConnection(pstmt,rs);
		return dto;
	}
	
	
}
