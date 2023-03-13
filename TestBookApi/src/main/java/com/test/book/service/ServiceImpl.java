package com.test.book.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.test.book.entity.Book;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service{
	
	public static List<Book> list=new ArrayList<>();
	
	static {
		list.add(new Book(101,"Java Book","Sanket Kale"));
		list.add(new Book(111,"Spring-Boot Book","Aditya"));
		list.add(new Book(232,"Python Book","Abhishek"));
		
		}
	
	@Override
	public List<Book> getAllBooks() {
		return list;
	}
	
	public Book getBookById(int Id) {
		Book book=null;
		try {
			book=list.stream().filter(e-> e.getId()==Id).findFirst().get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book;
	}

	@Override
	public Book addBook(Book book) {
		list.add(book);
		return book;
	}

	@Override
	public void updateBookById(Book book, int id) {
		list=list.stream().map(b->{
			if(b.getId()==id) {
				b.setbName(book.getbName());
				b.setAuther(book.getAuther());
			}
			return b;
		}).collect(Collectors.toList());
	}

	@Override
	public void deleteBook(int id) {
		list=list.stream().filter(book -> book.getId()!=id).
				collect(Collectors.toList());
		
	}
	
	

}
