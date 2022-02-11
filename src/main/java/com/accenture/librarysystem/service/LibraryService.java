package com.accenture.librarysystem.service;

import java.util.List;
import org.springframework.stereotype.Component;
import com.accenture.librarysystem.entity.Library;

@Component
public interface LibraryService {
	
	List<Library> addBooks(List<Library> library);
	List<Library> getBook(int bookId);
	void deleteBook(int bookId);
	List<Library> addBook(Library library);
	void updateBook(String bookName , String bookAuthor);
	List<Library> getAllBooks();
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	
//	@Autowired 
//	LibraryDAO dao;
//	
//	public String addBook(Library library) {
//		dao.save(library);
//		return "New Book added";
//		
//	}
//	
//	public String addBooks(List<Library> library) {
//		dao.saveAll(library);
//		return "New Books are added";
//		
//	}
//	
//	public void deleteBook(int bookId) {
//		dao.deleteById(bookId);
//	}
//	
//	public String updateBook(Library library) {
//		dao.save(library);
//		return "New Book updated";
//		
//	}
//	
////	public Library getBook(int bookId) {
////		return dao.findById(bookId).get();
////	}
//	
//	public List<Library> getBooks(){
//		return dao.findAll();
//			
//	}
//	
//	public void deleteAll() {
//		dao.deleteAll();
//	}
//	
//	@Query("SELECT a from library_info where bookId=?1")
//	public Library getBooks(int bookId) {
//		return dao.findById(bookId).get();
//		
//		
//	}
//}
