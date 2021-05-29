package com.chainsys.book.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import com.chainsys.book.model.Book;

public interface BookDao {
	
	Set<Book> ViewDetail();
	
	public void insertData(Book book);
	
	public Book searchById(int id);
	
	public Book searchByName(String name);
	
	public Book searchByDate(LocalDate date);
	
	public void updateBookByIdName(Book book);
	
	public void updateBookByIdDate(Book book);
	
	public void updateBookByNameId(Book book);
	
	public void updateBookByNameDate(Book book);
	
	public void updateBookByDateId(Book book);
	
	public void updateBookByDateName(Book book);
	
	public void DeleteBookById(int id);
	
	public void DeleteBookByName(String name);
	
	public void DeleteBookByDate(LocalDate date);
	
	public List<Integer> viewAllBookId();
	
	public List<String> viewAllBookName();
	
}
