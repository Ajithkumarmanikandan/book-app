package com.chainsys.book.test;

import com.chainsys.book.exception.BookNotFoundException;
import com.chainsys.book.model.Book;
import com.chainsys.book.service.ServiceBook;
import com.chainsys.book.service.ServiceBookImpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class BookClient {

	public static void main(String[] args) {
	
		Set<Book> bookSet;
		List<Integer> listBookId;
		List<String> listBookName;
		Book book;
		//Creating an instance for ServiceBookImpl
		ServiceBook service = new ServiceBookImpl();
		Scanner scan = new Scanner(System.in);
		int menuChoice;
		int choice;
		int colChoice;
		int book_id;
		String book_name;
		String publish_date;
		DateTimeFormatter dateFormat;
		//Menus
		System.out.println("1. View details");
		System.out.println("2. Add a book");
		System.out.println("3. Update book");
		System.out.println("4. Delete a book");
		System.out.println("5. Search book");
		System.out.println("6. ViewAllBookId");
		System.out.println("7. ViewAllBookName");
		// loop will execute infinitely until user input will be non-zero
		while(true) {
			System.out.println("Enter the Choice :");
			//getting choice from the user
			menuChoice = scan.nextInt();
			switch(menuChoice) {
				//To view the Details of Book
				case 1:
					bookSet = service.ViewDetail();
					System.out.println(bookSet);
					break;
				//To insert data into table
				case 2:
					System.out.println("Enter Book Id:");
					book_id = scan.nextInt();
					System.out.println("Enter Book name");
					book_name = scan.next();
					System.out.println("Enter publish date");
					publish_date = scan.next();
					dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
					try {
					book = new Book(book_id,book_name,LocalDate.parse(publish_date,dateFormat));
					service.insertData(book);
					bookSet = service.ViewDetail();
					System.out.println(bookSet);
					}
					catch(Exception e) {
						System.out.println(e);
					}
					break;
				//To update Book on table
				case 3:
					System.out.println("Select Choice for update book:");
					System.out.println("1. Update book by ID");
					System.out.println("2. Update book by Name");
					System.out.println("3. Update book by Publish Date");
					choice = scan.nextInt();
					//To update Book by Book_id
					if(choice == 1) {
						System.out.println("Enter the Id :");
						book_id = scan.nextInt();
						System.out.println("What to update :");
						System.out.println("1. Name");
						System.out.println("2. Date");
						colChoice = scan.nextInt();
						//To update Book_name by Book_id
						if(colChoice == 1) {
							System.out.println("Enter the name :");
							book_name = scan.next();
							try {
							book = service.searchById(book_id);
							Book updBook = new Book(book_id,book_name,book.getPublishDate());
							service.updateBookByIdName(updBook);
							bookSet = service.ViewDetail();
							System.out.println(bookSet);
							}
							catch(BookNotFoundException e) {
								
							}
						}
						//To update publishDate by Book_id
						else if(colChoice == 2) {
							System.out.println("Enter the Publish Date");
							publish_date = scan.next();
							dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
							try {
							book = service.searchById(book_id);
							Book updBook = new Book(book_id,book.getName(),LocalDate.parse(publish_date,dateFormat));
							service.updateBookByIdDate(updBook);
							bookSet = service.ViewDetail();
							System.out.println(bookSet);
							}
							catch(BookNotFoundException e) {
								
							}
						}
						else {
							System.out.println("Invalid choice!!! Select 1 or 2");
						}	
					}
					//To update Book by Book_name
					else if(choice == 2) {
						System.out.println("Enter the name :");
						book_name = scan.next();
						System.out.println("What to update :");
						System.out.println("1. Id");
						System.out.println("2. Date");
						colChoice = scan.nextInt();
						//To update Book_id by Book_name
						if(colChoice == 1) {
							System.out.println("Enter the ID :");
							book_id = scan.nextInt();
							try {
							book = service.searchByName(book_name);
							Book updBook = new Book(book_id,book_name,book.getPublishDate());
							service.updateBookByNameId(updBook);
							bookSet = service.ViewDetail();
							System.out.println(bookSet);
							}
							catch(BookNotFoundException e) {
								
							}
						}
						//To update publishDate by Book_name
						else if(colChoice == 2) {
							System.out.println("Enter the Publish Date :");
							publish_date = scan.next();
							dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
							try {
								book = service.searchByName(book_name);
								Book updBook = new Book(book.getId(),book_name,LocalDate.parse(publish_date,dateFormat));
								service.updateBookByNameDate(updBook);
								bookSet = service.ViewDetail();
								System.out.println(bookSet);
							}
							catch(BookNotFoundException e) {
								
							}
						}
						else {
							System.out.println("Invalid choice!!! Select 1 or 2");
						}
					}
					//To update Book by publishDate
					else if(choice == 3) {
						System.out.println("Enter the Publish Date :");
						publish_date = scan.next();
						dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
						System.out.println("What to update :");
						System.out.println("1. Id");
						System.out.println("2. Name");
						colChoice = scan.nextInt();
						//To update Book_id by publishDate
						if(colChoice == 1) {
							System.out.println("Enter the Id :");
							book_id = scan.nextInt();
							try {
								book = service.searchByDate(LocalDate.parse(publish_date,dateFormat));
								Book updBook = new Book(book_id,book.getName(),LocalDate.parse(publish_date,dateFormat));
								service.updateBookByDateId(updBook);
								bookSet = service.ViewDetail();
								System.out.println(bookSet);
							}
							catch(BookNotFoundException e) {
								
							}
						}
						//To update Book_name by publishDate
						else if(colChoice == 2) {
							System.out.println("Enter the name :");
							book_name = scan.next();
							try {
								book = service.searchByDate(LocalDate.parse(publish_date,dateFormat));
								Book updBook = new Book(book.getId(),book_name,LocalDate.parse(publish_date,dateFormat));
								service.updateBookByDateName(updBook);
								bookSet = service.ViewDetail();
								System.out.println(bookSet);
							}
							catch(BookNotFoundException e) {
								
							}
						}
						else {
							System.out.println("Invalid choice!!! Select 1 or 2");
						}
					}
					else {
						System.out.println("Invalid choice!!! Can't Update book");
					}
					break;
				//To delete Book on table	
				case 4:
					System.out.println("Select Choice for delete:");
					System.out.println("1. Delete book by ID");
					System.out.println("2. Delete book by Name");
					System.out.println("3. Delete book by Publish Date");
					choice = scan.nextInt();
					//To delete Book by Book_id
					if(choice == 1) {
						System.out.println("Enter the Id :");
						book_id = scan.nextInt();
						try {
							service.DeleteBookById(book_id);
							bookSet = service.ViewDetail();
							System.out.println(bookSet);
						}
						catch(BookNotFoundException e) {
							
						}
					}
					//To delete Book by Book_name
					else if(choice == 2) {
						System.out.println("Enter the Name :");
						book_name = scan.next();
						try {
							service.DeleteBookByName(book_name);
							bookSet = service.ViewDetail();
							System.out.println(bookSet);
						}
						catch(BookNotFoundException e) {
							
						}
					}
					//To delete Book by Book PublishDate
					else if(choice == 3) {
						System.out.println("Enter the Date :");
						publish_date = scan.next();
						dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
						try {
							service.DeleteBookByDate(LocalDate.parse(publish_date,dateFormat));
							bookSet = service.ViewDetail();
							System.out.println(bookSet);
						}
						catch(BookNotFoundException e) {
							
						}
					}
					else {
						System.out.println("Invalid choice!!! Can't delete book");
					}
					break;
				//To search the book
				case 5:
					System.out.println("1. Search book by Id");
					System.out.println("2. Search book by Name");
					System.out.println("3. Search book by Publish Date");
					colChoice = scan.nextInt();
					//To search Book by Book_Id
					if(colChoice == 1) {
						System.out.println("Enter the Id :");
						book_id = scan.nextInt();
						try {
						Book searchBook = service.searchById(book_id);
						System.out.println(searchBook);
						}
						catch(BookNotFoundException e) {
							
						}
					}
					//To search Book by Book_name
					else if(colChoice == 2) {
						System.out.println("Enter the Name :");
						book_name = scan.next();
						try {
							Book searchBook = service.searchByName(book_name);
							System.out.println(searchBook);
							}
							catch(BookNotFoundException e) {
								
							}
					}
					//To search Book by Book Publish Date
					else if(colChoice == 3) {
						System.out.println("Enter the Publish Date :");
						publish_date = scan.next();
						dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
						try {
							Book searchBook = service.searchByDate(LocalDate.parse(publish_date,dateFormat));
							System.out.println(searchBook);
							}
							catch(BookNotFoundException e) {
								
							}
					}
					break;
				//To View All BookId
				case 6:
					listBookId = service.viewAllBookId();
					System.out.println(listBookId);
					break;
				//To View All BookName
				case 7:
					listBookName = service.viewAllBookName();
					System.out.println(listBookName);
					break;
				default:
					System.exit(0);
					break;
			}
		}
	}

}
