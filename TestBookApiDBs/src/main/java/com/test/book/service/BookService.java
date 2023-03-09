package com.test.book.service;

import java.util.List;

import com.test.book.entity.Book;

public interface BookService {
	
	public List<Book> getAllBooks();
	
	public Book getBookById(int Id);
	
	public Book addBook(Book book);

	public void updateBookById(Book book, int id);
	
	public void deleteBook(int id);

}
