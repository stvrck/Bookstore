package swd20.hh.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import swd20.hh.bookstore.domain.Book;
import swd20.hh.bookstore.domain.BookRepository;
import swd20.hh.bookstore.domain.Category;
import swd20.hh.bookstore.domain.CategoryRepository;



@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner studentDemo(BookRepository repository, CategoryRepository catrepository) {
		return (args) -> {
		
			Book b1 = new Book("Kirja", "Kalle Kirjanen", 2012, 123, 25);
			Book b2 = new Book("Opus deus", "Olli Opus", 2010, 500, 19);
			Book b3 = new Book("Tiiliskivi", "Niilo Nide", 2008, 200, 37);
			
			repository.save(b1);
			repository.save(b3);
			repository.save(b2);

			
			Category c1 = new Category("Scifi");
			Category c2 = new Category("Drama");
			Category c3 = new Category("Fantasy");
			
            catrepository.save(c1);
            catrepository.save(c2);
            catrepository.save(c3);
			
		};
	}
}
