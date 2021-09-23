package swd20.hh.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import swd20.hh.bookstore.domain.Book;
import swd20.hh.bookstore.domain.BookRepository;



@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner studentDemo(BookRepository repository) {
		return (args) -> {
		
			repository.save(new Book("Kirja", "Kalle Kirjanen", 2012, 123, 25));
			repository.save(new Book("Opus deus", "Olli Opus", 2010, 500, 19));
			repository.save(new Book("Tiiliskivi", "Niilo Nide", 2008, 200, 37));
			
			//Book b1 = new Book("Kirja", "Kalle Kirjanen", 2012, 123, 25);
			//Book b2 = new Book("Opus deus", "Olli Opus", 2010, 500, 19);
			//Book b3 = new Book("Tiiliskivi", "Niilo Nide", 2008, 200, 37);
			
		};
	}
}
