package com.chainsys.book.exception;

public class BookNotFoundException extends Exception{

	public BookNotFoundException(String message) {
		System.out.println(message);
	}
}
