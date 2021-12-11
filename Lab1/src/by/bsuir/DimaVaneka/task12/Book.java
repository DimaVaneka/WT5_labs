package by.bsuir.DimaVaneka.task12;



public class Book implements Cloneable, Comparable<Book>{
	
	private String title;
	private String author;
	private int price;
	private static int edition;
	private int isbn;
	
	public Book(String title, String author, int price, int isbn){
		
        this.author = author;
        this.title = title;
        this.price = price;
        this.isbn = isbn;
        
  }

	
	
	 public String getAuthor(){
	        return author;
	    }

	    public String getTitle(){
	        return title;
	    }

	    public int getPrice(){
	        return price;
	    }
	    
	    public int getIsbn(){
	        return isbn;
	    }

	    public int getEdition(){
	        return Book.edition;
	    }
	    
	    public static void setEdition(int edition){
	    	Book.edition = edition;
	    }
	    
	    
	    
	    @Override
	    public String toString() {
	        return this.getClass() + ": " + "title: " + this.title + " author: " + this.author + " price: " + this.price + " edition: " + Book.edition;
	    }
	    
	    @Override
	    public int hashCode() {
	    	 final int prime = 31;
	    	    int result = 1;
	    	    result = prime * result + ((title == null) ? 0 : title.hashCode());             
	    	    result = prime * result + price; 
	    	    result = prime * result + ((author == null) ? 0 : author.hashCode()); return result;
	    	    
	    }
	    
	    
	    public boolean equals(Object obj) {
	        if (obj == this) {
	            return true;
	        }
	        if (obj == null || obj.getClass() != this.getClass()) {
	            return false;
	        }

	        Book book = (Book) obj;
	        return (title != null && title.equals(book.getTitle())) && (author != null && author.equals(book.getAuthor()) && (this.price == book.getPrice())) ; 
	    }
	    
	    
	    
	    @Override
	    public Book clone(){
	        return new Book(this.title, this.author, this.price, this.isbn);
	    }

	    @Override
	    public int compareTo(Book book){
	        return this.isbn - book.isbn;
	    }
	

}
