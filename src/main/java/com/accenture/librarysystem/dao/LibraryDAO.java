package com.accenture.librarysystem.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.accenture.librarysystem.entity.Library;

public interface LibraryDAO extends JpaRepository<Library, Integer> {

	@Query("select s from Library s where s.bookId=?1")
	List<Library> getBook(int bookId);

	@Transactional
	@Modifying
	@Query("DELETE FROM Library s WHERE s.bookId=?1" )
	void deleteBook(int bookId);

	@Transactional
	@Modifying
	@Query(value="INSERT INTO library_details (bookId,bookName,bookAuthor) VALUES (?1,'?2','?3')",nativeQuery=true)
	List<Library> addBook(@RequestBody Library library);

	@Transactional
	@Modifying
	@Query("UPDATE Library SET bookName = :bookName WHERE bookAuthor = :bookAuthor")
	Integer updateBook(String bookName , String bookAuthor);

	@Query("SELECT s FROM Library s")
	List<Library> getAllBooks();

}
