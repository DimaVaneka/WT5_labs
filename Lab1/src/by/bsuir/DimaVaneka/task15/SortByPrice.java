package by.bsuir.DimaVaneka.task15;


import by.bsuir.DimaVaneka.task12.Book;

import java.util.Comparator;

public class SortByPrice implements Comparator<Book> {

	
	@Override
    public int compare(Book book1, Book book2) {
        if ((book1 == null) || (book2 == null)) {
            throw new IllegalArgumentException("Both books shouldn't be null");
        }

        return Integer.compare(book1.getPrice(), book2.getPrice());
    }
	
}
