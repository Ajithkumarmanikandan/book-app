package com.chainsys.book.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;


import com.chainsys.book.dao.BookDao;
import com.chainsys.book.dao.BookDaoImpl;
import com.chainsys.book.exception.BookNotFoundException;
import com.chainsys.book.model.Book;

public class ServiceBookImpl implements ServiceBook {

	private static BookDao bdao;
	
	public ServiceBookImpl() {
		bdao = new BookDaoImpl();
	}
	
	@Override
	public Set<Book> ViewDetail(){
		return bdao.ViewDetail();
	}
	
	@Override
	public void insertData(Book book) {
		bdao.insertData(book);
	}
	
	@Override
	public Book searchById(int id) throws BookNotFoundException{
		Book book = bdao.searchById(id);
		if(book == null) {
			throw new BookNotFoundException("Book Id Not Found");
		}
		else {
			return book;
		}
	}
	
	@Override
	public Book searchByName(String name) throws BookNotFoundException{
		Book book=bdao.searchByName(name);
		if(book == null) {
			throw new BookNotFoundException("Book Name Not Found");
		}
		else {
			return book;
		}
	}
	
	@Override
	public Book searchByDate(LocalDate date)throws BookNotFoundException{
		Book book = bdao.searchByDate(date);
		if(book == null) {
			throw new BookNotFoundException("Book Publish Date Not Found");
		}
		else {
			return book;
		}
	}
	
	@Override
	public void updateBookByIdName(Book book) throws BookNotFoundException{
		Book updBook = bdao.searchById(book.getId());
		if (updBook == null) {
			throw new BookNotFoundException("Book Id Not Found");
		}
		else {
			bdao.updateBookByIdName(book);
		}
	}
	
	@Override
	public void updateBookByIdDate(Book book) throws BookNotFoundException{
		Book updBook = bdao.searchById(book.getId());
		if (updBook == null) {
			throw new BookNotFoundException("Book Id Not Found");
		}
		else {
			bdao.updateBookByIdDate(book);
		}
	}
	
	@Override
	public void updateBookByNameId(Book book) throws BookNotFoundException{
		Book updBook = bdao.searchByName(book.getName());
		if(updBook == null) {
			throw new BookNotFoundException("Book Name Not Found");
		}
		else {
			bdao.updateBookByNameId(book);
		}
	}
	
	@Override
	public void updateBookByNameDate(Book book) throws BookNotFoundException{
		Book updBook = bdao.searchByName(book.getName());
		if(updBook == null) {
			throw new BookNotFoundException("Book Name Not Found");
		}
		else {
			bdao.updateBookByNameDate(book);
		}
	}
	
	@Override
	public void updateBookByDateId(Book book) throws BookNotFoundException{
		Book updBook = bdao.searchByDate(book.getPublishDate());
		if(updBook == null) {
			throw new BookNotFoundException("Book Publish Date Not Found");
		}
		else {
			bdao.updateBookByDateId(book);
		}
	}
	
	@Override
	public void updateBookByDateName(Book book) throws BookNotFoundException{
		Book updBook = bdao.searchByDate(book.getPublishDate());
		if(updBook == null) {
			throw new BookNotFoundException("Book Publish Date Not Found");
		}
		else {
			bdao.updateBookByDateName(book);
		}
	}
	
	@Override
	public void DeleteBookById(int id) throws BookNotFoundException{
		Book book = bdao.searchById(id);
		if(book == null) {
			throw new BookNotFoundException("Book Id Not Found");
		}
		else {
			bdao.DeleteBookById(id);
		}
	}
	
	@Override
	public void DeleteBookByName(String name) throws BookNotFoundException{
		Book book = bdao.searchByName(name);
		if(book == null) {
			throw new BookNotFoundException("Book Name Not Found");
		}
		else {
			bdao.DeleteBookByName(name);
		}
	}
	
	@Override
	public void DeleteBookByDate(LocalDate date) throws BookNotFoundException{
		Book book = bdao.searchByDate(date);
		if(book == null) {
			throw new BookNotFoundException("Book PublishDate Not Found");
		}
		else {
			bdao.DeleteBookByDate(date);
		}
	}
	
	@Override
	public List<Integer> viewAllBookId(){
		return bdao.viewAllBookId();
	}
	
	@Override
	public List<String> viewAllBookName(){
		return bdao.viewAllBookName();
	}
}
