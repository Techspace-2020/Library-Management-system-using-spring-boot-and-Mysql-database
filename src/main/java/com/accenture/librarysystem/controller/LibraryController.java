package com.accenture.librarysystem.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.librarysystem.exception.ResourceNotFoundException;
import com.accenture.librarysystem.dao.LibraryDAO;
import com.accenture.librarysystem.entity.Library;
import com.accenture.librarysystem.service.LibraryService;

@RestController
@RequestMapping("/libraryservice")
public class LibraryController {

	@Autowired
	LibraryService libraryservice;

	@Autowired 
	LibraryDAO dao;

	@PostMapping("/addbooks")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Library> saveBooks(@RequestBody List<Library> library){
		libraryservice.addBooks(library);
		return new ResponseEntity<Library>(HttpStatus.OK);
//		List<Library> book = (List<Library>)
//		return book;

	}

	@GetMapping("/getbooks/{bookId}")
	public ResponseEntity<Library> getBooks(@PathVariable int bookId)
			throws ResourceNotFoundException{
		Library library = dao.findById(bookId)
				.orElseThrow(() -> new ResourceNotFoundException("Book not found for this Id: "+ bookId));
		return ResponseEntity.ok().body(library);

	}

	@DeleteMapping("/deletebook/{bookId}")
	public ResponseEntity<Library> deletBook(@PathVariable int bookId)
			throws ResourceNotFoundException{
		Library library = dao.findById(bookId)
				.orElseThrow(() -> new ResourceNotFoundException("Book not found for this Id to delete: "+ bookId));
		dao.deleteById(bookId);
		return ResponseEntity.ok().body(library);
	}

	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public List<Library>  addBook(@RequestBody Library library) {
		return libraryservice.addBook(library);

	}

	@PutMapping("/updatebook")
	public ResponseEntity<String> updateBook(@RequestBody String bookName , String bookAuthor){
		dao.updateBook(bookName, bookAuthor);
		return new ResponseEntity<String>("Book Updated Successfully!!!", HttpStatus.OK);
	}

	@GetMapping("/allbooks")
	public List<Library> getAllBooks(){
		return libraryservice.getAllBooks();
	}

	//@PutMapping
}
















































/*@PostMapping("/add")
	public String addBook(@RequestBody Library library) {
		return libraryservice.addBook(library);

	}

	@PostMapping("/all")
	public String addBooks(@RequestBody List<Library> library) {
		return libraryservice.addBooks(library);

	}

	@DeleteMapping("/all/{bookId}")
	public String deleteBook(@PathVariable int bookId) {
		libraryservice.deleteBook(bookId);
		return "Book is deleted";
	}

	@DeleteMapping("/all")
	public String deleteAll() {
		libraryservice.deleteAll();
		return "deleted successfully";
	}

	@PutMapping("/update")
	public String updateBook(@RequestBody Library library) {
		return libraryservice.updateBook(library);
	}

	@GetMapping("/all/{bookId}")
	public Library getBook(@PathVariable int bookId) {
		return libraryservice.getBooks(bookId);
	}

	@GetMapping("/all")
	public List<Library> getBooks(){
		return libraryservice.getBooks();
	}


}*/
