package com.chainsys.book.dao;

import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.chainsys.book.model.Book;

public class BookDaoImpl implements BookDao {
	
	public Connection con;
	public Set<Book> bookSet;
	public PreparedStatement pstmt;
	public ResultSet result;
	public ArrayList<Integer> listBookId;
	public ArrayList<String> listBookName;
	public BookDaoImpl() {
		try {
			Class.forName("oracle:jdbc:driver:OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.20:1521:EBS1228", "apps", "apps");
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Set<Book> ViewDetail(){
		try {
			pstmt = con.prepareStatement("SELECT * FROM BOOK_2608");
			result = pstmt.executeQuery();
			bookSet = new HashSet<>();
			while(result.next()) {
				Book book = new Book(result.getInt("b_id"),result.getString("b_name"),result.getDate("pub_date").toLocalDate());
				bookSet.add(book);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return bookSet;
	}
	
	@Override
	public void insertData(Book book) {
		try {
		pstmt = con.prepareStatement("INSERT INTO BOOK_2608 (b_id,b_name,pub_date) VALUES (?,?,?)");
		pstmt.setInt(1, book.getId());
		pstmt.setString(2, book.getName());
		pstmt.setDate(3, Date.valueOf(book.getPublishDate()));
		pstmt.executeQuery();
		System.out.println("Datas Inserted Successfully!!!");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Book searchById(int id) {
		Book book = null;
		try {
			pstmt = con.prepareStatement("SELECT * FROM BOOK_2608 WHERE b_id = ?");
			pstmt.setInt(1, id);
			result = pstmt.executeQuery();
			while(result.next()) {
				book = new Book(result.getInt("b_id"),result.getString("b_name"),result.getDate("pub_date").toLocalDate());
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return book;
	}
	
	@Override
	public Book searchByName(String name) {
		Book book = null;
		try {
			pstmt = con.prepareStatement("SELECT * FROM BOOK_2608 WHERE b_name = ?");
			pstmt.setString(1,name);
			result = pstmt.executeQuery();
				while(result.next()) {
					book = new Book(result.getInt("b_id"),result.getString("b_name"),result.getDate("pub_date").toLocalDate());
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			return book;
	}
	
	@Override
	public Book searchByDate(LocalDate date) {
		Book book = null;
		try {
			pstmt = con.prepareStatement("SELECT * FROM BOOK_2608 WHERE pub_date = ?");
			pstmt.setDate(1,Date.valueOf(date));
			result = pstmt.executeQuery();
			while(result.next()) {
				book = new Book(result.getInt("b_id"),result.getString("b_name"),result.getDate("pub_date").toLocalDate());
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return book;
	}
	
	@Override
	public void updateBookByIdName(Book book) {
		try {
			pstmt = con.prepareStatement("UPDATE BOOK_2608 SET b_name = ? WHERE b_id = ?");
			pstmt.setString(1,book.getName());
			pstmt.setInt(2, book.getId());
			pstmt.executeQuery();
			System.out.println("Updated Successfully!!!");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void updateBookByIdDate(Book book) {
		try {
			pstmt = con.prepareStatement("UPDATE BOOK_2608 SET pub_date = ? WHERE b_id = ?");
			pstmt.setDate(1, Date.valueOf(book.getPublishDate()));
			pstmt.setInt(2, book.getId());
			pstmt.executeQuery();
			System.out.println("Updated Successfully!!!");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void updateBookByNameId(Book book) {
		try {
			pstmt = con.prepareStatement("UPDATE BOOK_2608 SET b_id = ? WHERE b_name = ?");
			pstmt.setInt(1, book.getId());
			pstmt.setString(2, book.getName());
			pstmt.executeQuery();
			System.out.println("Updated Successfully!!!");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void updateBookByNameDate(Book book) {
		try {
			pstmt = con.prepareStatement("UPDATE BOOK_2608 SET pub_date = ? WHERE b_name = ?");
			pstmt.setDate(1, Date.valueOf(book.getPublishDate()));
			pstmt.setString(2, book.getName());
			pstmt.executeQuery();
			System.out.println("Updated Successfully!!!");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void updateBookByDateId(Book book) {
		try {
			pstmt = con.prepareStatement("UPDATE BOOK_2608 SET b_id = ? WHERE pub_date = ?");
			pstmt.setInt(1, book.getId());
			pstmt.setDate(2, Date.valueOf(book.getPublishDate()));
			pstmt.executeQuery();
			System.out.println("Updated Successfully!!!");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void updateBookByDateName(Book book) {
		try {
			pstmt = con.prepareStatement("UPDATE BOOK_2608 SET b_name = ? WHERE pub_date = ?");
			pstmt.setString(1, book.getName());
			pstmt.setDate(2, Date.valueOf(book.getPublishDate()));
			pstmt.executeQuery();
			System.out.println("Updated Successfully!!!");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void DeleteBookById(int id) {
		try {
			pstmt = con.prepareStatement("DELETE BOOK_2608 WHERE b_id = ?");
			pstmt.setInt(1, id);
			pstmt.executeQuery();
			System.out.println("Deleted Successfully!!!");
		}
		catch(SQLException e) {
			
		}
	}
	
	@Override
	public void DeleteBookByName(String name) {
		try {
			pstmt = con.prepareStatement("DELETE BOOK_2608 WHERE b_name = ?");
			pstmt.setString(1, name);
			pstmt.executeQuery();
			System.out.println("Deleted Successfully!!!");
		}
		catch(SQLException e) {
			
		}
	}
	
	@Override
	public void DeleteBookByDate(LocalDate date) {
		try {
			pstmt = con.prepareStatement("DELETE BOOK_2608 WHERE pub_date = ?");
			pstmt.setDate(1, Date.valueOf(date));
			pstmt.executeQuery();
			System.out.println("Deleted Successfully!!!");
		}
		catch(SQLException e) {
			
		}
	}
	
	public List<Integer> viewAllBookId(){
		try {
			pstmt = con.prepareStatement("SELECT b_id FROM BOOK_2608");
			result = pstmt.executeQuery();
			while(result.next()) {
				listBookId.add(result.getInt("b_id"));
			}
		  }
			catch(SQLException e) {
				e.printStackTrace();
			}
		return listBookId;
		}
	
	public List<String> viewAllBookName(){
		try {
			pstmt = con.prepareStatement("SELECT b_name FROM BOOK_2608");
			result = pstmt.executeQuery();
			while(result.next()) {
				listBookName.add(result.getString("b_name"));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return listBookName;
	}
	
}
