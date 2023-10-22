package com.springtutorial.springwebapp.bootstrap;

import com.springtutorial.springwebapp.domain.Author;
import com.springtutorial.springwebapp.domain.Book;
import com.springtutorial.springwebapp.domain.Publisher;
import com.springtutorial.springwebapp.repositories.AuthorRepository;
import com.springtutorial.springwebapp.repositories.BookRepository;
import com.springtutorial.springwebapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class BootstrapData implements CommandLineRunner {

    Scanner scanner = new Scanner(System.in);

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

        Author rod = new Author();
        rod.setFirstName("Rodwqd");
        rod.setLastName("Johnson");

        Book someBook = new Book();
        someBook.setTitle("Some title for the first book");
        someBook.setIsbn("123456781");

        Book someBook2 = new Book();
        someBook2.setTitle("Some title for the second book");
        someBook2.setIsbn("123456781");

        Author rodSaved = authorRepository.save(rod);
        Book someBookSaved = bookRepository.save(someBook);
        Book someBookSaved2 = bookRepository.save(someBook2);


        rodSaved.getBooks().add(someBookSaved);
        rodSaved.getBooks().add(someBookSaved2);

        someBookSaved.getAuthors().add(rodSaved);
        someBookSaved2.getAuthors().add(rodSaved);

        Publisher amazonBooks = new Publisher();
        amazonBooks.setPublisherName("Amazon Books");
        amazonBooks.setAddress("Schubert Street 33");
        amazonBooks.setCity("Schwenningen");
        amazonBooks.setState("Badden");
        amazonBooks.setZip("78647");

        Publisher amazonBooksSaved = publisherRepository.save(amazonBooks);

        someBookSaved.setPublisher(amazonBooksSaved);
        someBook.setPublisher(amazonBooksSaved);
        someBook2.setPublisher(amazonBooksSaved);

        bookRepository.save(someBook);
        bookRepository.save(someBook2);

        authorRepository.save(rodSaved);
    }
}