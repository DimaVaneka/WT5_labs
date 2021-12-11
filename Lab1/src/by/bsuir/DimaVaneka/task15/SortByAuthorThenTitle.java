package by.bsuir.DimaVaneka.task15;

import by.bsuir.DimaVaneka.task12.Book;

import java.util.Comparator;

public class SortByAuthorThenTitle implements Comparator<Book> {

	Comparator<Book> comparator;
	
	public SortByAuthorThenTitle(){
		
		comparator = new SortByAuthor().thenComparing(new SortByTitle());
	}
	
	 public int compare(Book book1, Book book2) {
	        if ((book1 == null) || (book2 == null)) {
	            throw new IllegalArgumentException("Both books shouldn't be null");
	        }

	        return comparator.compare(book1, book2);
	    }
	
}
