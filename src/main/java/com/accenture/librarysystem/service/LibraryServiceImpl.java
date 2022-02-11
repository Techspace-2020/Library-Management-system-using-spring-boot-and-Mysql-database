package com.accenture.librarysystem.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.accenture.librarysystem.dao.LibraryDAO;
import com.accenture.librarysystem.entity.Library;

@Service
public class LibraryServiceImpl implements LibraryService{

	@Autowired 
	LibraryDAO librarydao;

	@Override
	public List<Library> addBooks(List<Library> library) {
		List<Library> response = (List<Library>) 
				librarydao.saveAll(library);
		return response;
	}

	@Override
	public List<Library> getBook(int bookId) {
		return librarydao.getBook(bookId);			

	}

	@Override
	public void deleteBook(int bookId) {
		librarydao.deleteBook(bookId);

	}

	@Override
	public List<Library> addBook(Library library) {
		return librarydao.addBook(library);

	}


	@Override
	public void updateBook(String bookName, String bookAuthor) {
		librarydao.updateBook(bookName, bookAuthor);

	}

	@Override
	public List<Library> getAllBooks() {
		return librarydao.getAllBooks();
	}

}
