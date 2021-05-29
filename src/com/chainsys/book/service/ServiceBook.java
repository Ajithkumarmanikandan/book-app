package com.chainsys.book.service;

import java.util.List;
import java.util.Set;
import java.time.LocalDate;

import com.chainsys.book.exception.BookNotFoundException;
import com.chainsys.book.model.Book;

public interface ServiceBook {

	Set<Book> ViewDetail();
	
	public void insertData(Book book);
	
	public Book searchById(int id) throws BookNotFoundException;
	
	public Book searchByName(String name) throws BookNotFoundException;
	
	public Book searchByDate(LocalDate date) throws BookNotFoundException;
	
	public void updateBookByIdName(Book book) throws BookNotFoundException;
	
	public void updateBookByIdDate(Book book) throws BookNotFoundException;
	
	public void updateBookByNameId(Book book) throws BookNotFoundException;
	
	public void updateBookByNameDate(Book book) throws BookNotFoundException;
	
	public void updateBookByDateId(Book book) throws BookNotFoundException;
	
	public void updateBookByDateName(Book book) throws BookNotFoundException;
	
	public void DeleteBookById(int id) throws BookNotFoundException;
	
	public void DeleteBookByName(String Name) throws BookNotFoundException;
	
	public void DeleteBookByDate(LocalDate date) throws BookNotFoundException;
	
	public List<Integer> viewAllBookId();
	
	public List<String> viewAllBookName();
	
}
