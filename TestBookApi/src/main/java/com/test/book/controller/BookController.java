package com.test.book.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.book.entity.Book;
import com.test.book.service.Service;

//@Controller
//public class BookController {
//
//	@RequestMapping(value = "/book", method = RequestMethod.GET)
//	@ResponseBody
//	public String book()
//	{
//		System.out.println("Hiiii");
//		return " this is book controller";
//	}
//}

@RestController
public class BookController {
	
	@Autowired
	private Service bookService;
	
	//get all book handler
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBooks()
	{
		List<Book> list=this.bookService.getAllBooks();
		if(list.size()<=0) 
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); 
		}
		return ResponseEntity.of(Optional.of(list));
	}
	
//	//get single book handler
//	@GetMapping("/books/{Id}")
//	public Book getBook(@PathVariable("Id") int Id) {
//		
//		return bookService.getBookById(Id);
//	}
	
	//get single book handler
	@GetMapping("/books/{Id}")
	public ResponseEntity<Book> getBook(@PathVariable("Id") int Id) {
		
		Book book=bookService.getBookById(Id);
		if(book==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(book));
	}

	
//	//add new book handler
//	@PostMapping("/books")
//	public Book addBooks(@RequestBody Book book)
//	{
//		Book b=this.bookService.addBook(book);
//		//System.out.println(book);
//		return b;
//	}
	
	//add new book handler
		@PostMapping("/books")
		public ResponseEntity<Book> addBooks(@RequestBody Book book)
		{
			Book b=null;
			try {
				b=this.bookService.addBook(book);
				System.out.println(book);
				return ResponseEntity.of(Optional.of(b));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
		}
	
	//update single book handler
//	@PutMapping("/books/{Id}")
//	public Book updateBook(@RequestBody Book book, @PathVariable("Id") int Id)
//	{
//		this.bookService.updateBookById(book,Id);
//		//System.out.println(book);
//		return book;
//	}
		
	//update single book handler
	@PutMapping("/books/{Id}")
	public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable("Id") int Id)
	{
		try {
			this.bookService.updateBookById(book,Id);
			//System.out.println(book);
			return ResponseEntity.ok().body(book);
		} catch (Exception e) {
			
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	//delete book handler
//	@DeleteMapping("books/{Id}")
//	public void deleteBook(@PathVariable("Id") int Id) // bind id with path variable
//	{
//		this.bookService.deleteBook(Id);
//	}
	
	//delete book handler
	@DeleteMapping("books/{Id}")
	public ResponseEntity<Void> deleteBook(@PathVariable("Id") int Id) // bind id with apth variable
	{
		try {
			this.bookService.deleteBook(Id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
