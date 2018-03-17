package com.mandorbook.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.mandorbook.model.Author;
import com.mandorbook.model.Book;
import com.mandorbook.model.Publisher;
import com.mandorbook.model.repositories.AuthorRepository;
import com.mandorbook.model.repositories.BookRepository;
import com.mandorbook.model.repositories.PublisherRepository;

/**
 * 
 * @author ridwan
 *
 */

@Component
public class DevBootstrap implements ApplicationListener<
							ContextRefreshedEvent>{

	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;
	
	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		initData();
	}
	
	private void initData() {
		
		Publisher publisher = new Publisher();
		publisher.setName("foo");
		publisher.setAddress("griya");
		publisherRepository.save(publisher);
		
		//Eric
		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book("Domain Driven Design", "1234", publisher);
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		
		authorRepository.save(eric);
		bookRepository.save(ddd);
		
		//Rod
		Author rod = new Author("Rod", "Jhonson");
		Book noEjb = new Book("J2EE Development without EJB", "2344", publisher);
		rod.getBooks().add(noEjb);
		noEjb.getAuthors().add(rod);
		
		authorRepository.save(rod);
		bookRepository.save(noEjb);
	}
}