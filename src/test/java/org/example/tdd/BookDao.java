package org.example.tdd;

import java.util.Collections;
import java.util.List;


public class BookDao {
	private static final BookDao bookDAO = new BookDao();
	private BookDao() {}
	public static BookDao getInstance() {
		return bookDAO;
	}
	
	
	public List<Book> getAllBooks() {
		//TODO Database call
		return Collections.emptyList();
	}
	
	public Book getBook(String isbn) {
		//TODO Database call
		return null;
	}

	public String addBook(Book book) {
		return book.getIsbn();
	}

	public String updateBook(Book book) {
		return book.getIsbn();
	}
}
