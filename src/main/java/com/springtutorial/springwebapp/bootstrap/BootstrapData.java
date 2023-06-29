package com.springtutorial.springwebapp.bootstrap;

import com.springtutorial.springwebapp.domain.Author;
import com.springtutorial.springwebapp.domain.Book;
import com.springtutorial.springwebapp.repositories.AuthorRepository;
import com.springtutorial.springwebapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;

    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
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

        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);


        System.out.println(bookRepository.count());


    }
}
