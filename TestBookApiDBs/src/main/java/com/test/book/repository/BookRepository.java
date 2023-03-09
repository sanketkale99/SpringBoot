package com.test.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.book.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

	public Book findById(int Id);
}
