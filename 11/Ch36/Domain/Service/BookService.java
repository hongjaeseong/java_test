package Ch36.Domain.Service;

import java.util.List;

import Ch36.Domain.Dto.BookDto;

public interface BookService {

	BookDto getBook(int bookCode) throws Exception;

	List<BookDto> getAllBooks() throws Exception;

	boolean bookRegister(BookDto dto) throws Exception;

}