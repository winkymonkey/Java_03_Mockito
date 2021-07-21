package org.example.tdd;

import java.util.List;


public class Book {
	private String isbn;
	private String title;
	private List<String> authors;
	
	
	public Book(String isbn, String title, List<String> authors) {
		this.isbn = isbn;
		this.title = title;
		this.authors = authors;
	}
	
	
	public String getIsbn() {
		return isbn;
	}
	public String getTitle() {
		return title;
	}
	public List<String> getAuthors() {
		return authors;
	}
}
