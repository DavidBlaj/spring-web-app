package com.springtutorial.springwebapp.bootstrap;

import com.springtutorial.springwebapp.domain.Author;
import com.springtutorial.springwebapp.domain.Book;
import com.springtutorial.springwebapp.domain.Publisher;
import com.springtutorial.springwebapp.repositories.AuthorRepository;
import com.springtutorial.springwebapp.repositories.BookRepository;
import com.springtutorial.springwebapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("some lastname");

        Book book = new Book();
        book.setTitle("Some title");
        book.setIsbn("12345678");


        Author ericSaved = authorRepository.save(eric);
        Book bookSaved = bookRepository.save(book);


        Author rod = new Author();
        eric.setFirstName("Rod");
        eric.setLastName("Johnson");

        Book someBook = new Book();
        book.setTitle("Some title for the second book");
        book.setIsbn("123456781");


        Author rodSaved = authorRepository.save(rod);
        Book someBookSaved = bookRepository.save(someBook);

        ericSaved.getBooks().add(bookSaved);
        rodSaved.getBooks().add(someBookSaved);

        Publisher amazonBooks = new Publisher();
        amazonBooks.setPublisherName("Amazon Books");
        amazonBooks.setAddress("Schubert Street 33");
        amazonBooks.setCity("Schwenningen");
        amazonBooks.setState("Badden");
        amazonBooks.setZip("78647");

        Publisher amazonBooksSaved = publisherRepository.save(amazonBooks);

        bookSaved.setPublisher(amazonBooksSaved);
        book.setPublisher(amazonBooksSaved);

        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);
        bookRepository.save(bookSaved);
        bookRepository.save(book);

        System.out.println(publisherRepository.count());

    }
}
