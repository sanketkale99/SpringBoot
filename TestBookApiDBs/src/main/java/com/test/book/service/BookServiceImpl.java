package com.test.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.test.book.entity.Book;
import com.test.book.repository.BookRepository;

@org.springframework.stereotype.Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookRepository bookRepository;
//	public static List<Book> list=new ArrayList<>();
//	static {
//		list.add(new Book(101,"Java Book","Sanket Kale"));
//		list.add(new Book(111,"Spring-Boot Book","Aditya"));
//		list.add(new Book(232,"Python Book","Abhishek"));
//		
//		}
	
//	@Override
//	public List<Book> getAllBooks() {
//		return list;
//	}
	
	@Override
	public List<Book> getAllBooks() {
		return this.bookRepository.findAll();
	}

	//get single book by id
//	@Override
//	public Book getBookById(int Id) {
//		Book b1=null;
//		for(Book b:list) {
//			if(b.getId()==Id) {
//				b1=b;
//				break;
//			}
//		}
//		return b1;
//	}
	
//	public Book getBookById(int Id) {
//		Book book=null;
//		try {
//			book=list.stream().filter(e-> e.getId()==Id).findFirst().get();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return book;
//	}

	public Book getBookById(int Id) {
		Book book=null;
		try {
			book=this.bookRepository.findById(Id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book;
	}
	
//	@Override
//	public Book addBook(Book book) {
//		list.add(book);
//		return book;
//	}

	@Override
	public Book addBook(Book book) {
		Book result=bookRepository.save(book);
		return result;
	}
	
	
//	@Override
//	public void updateBookById(Book book, int id) {
//		list=list.stream().map(b->{
//			if(b.getId()==id) {
//				b.setbName(book.getbName());
//				b.setAuther(book.getAuther());
//			}
//			return b;
//		}).collect(Collectors.toList());
//	}
	
	@Override
	public void updateBookById(Book book, int id) {
		
		book.setId(id);
		bookRepository.save(book);
	}

//	@Override
//	public void deleteBook(int id) {
//		list=list.stream().filter(book -> book.getId()!=id).
//				collect(Collectors.toList());
//	}
	
	@Override
	public void deleteBook(int id) {
		bookRepository.deleteById(id);
	}
	

}
