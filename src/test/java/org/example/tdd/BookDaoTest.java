package org.example.tdd;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;


public class BookDaoTest {
	private static BookDao mockedBookDAO;
	private static Book book1;
	private static Book book2;

	@BeforeClass
	public static void setUp() {
		// Create mock object of BookDAO
		mockedBookDAO = mock(BookDao.class);

		// Create few instances of Book class.
		book1 = new Book("1234", "Book A", Arrays.asList("Author1","Author2","Author3","Author4"));
		book2 = new Book("5678", "Book B", Arrays.asList("AuthorX"));

		// Stubbing the methods of mocked BookDAL with mocked data.
		when(mockedBookDAO.getAllBooks()).thenReturn(Arrays.asList(book1, book2));
		when(mockedBookDAO.getBook("1234")).thenReturn(book1);
		when(mockedBookDAO.addBook(book1)).thenReturn(book1.getIsbn());
		when(mockedBookDAO.updateBook(book1)).thenReturn(book1.getIsbn());
	}

	
	@Test
	public void testGetAllBooks() throws Exception {
		List<Book> allBooks = mockedBookDAO.getAllBooks();
		assertEquals(2, allBooks.size());
		Book myBook = allBooks.get(0);
		assertEquals("1234", myBook.getIsbn());
		assertEquals("Book A", myBook.getTitle());
		assertEquals(4, myBook.getAuthors().size());
	}

	
	@Test
	public void testGetBook() {
		String isbn = "1234";
		Book myBook = mockedBookDAO.getBook(isbn);
		assertNotNull(myBook);
		assertEquals(isbn, myBook.getIsbn());
		assertEquals("Book A", myBook.getTitle());
		assertEquals(4, myBook.getAuthors().size());
	}

	
	@Test
	public void testAddBook() {
		String isbn = mockedBookDAO.addBook(book1);
		assertNotNull(isbn);
		assertEquals(book1.getIsbn(), isbn);
	}

	
	@Test
	public void testUpdateBook() {
		String isbn = mockedBookDAO.updateBook(book1);
		assertNotNull(isbn);
		assertEquals(book1.getIsbn(), isbn);
	}
	
}

