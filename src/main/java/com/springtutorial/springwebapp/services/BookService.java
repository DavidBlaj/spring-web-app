package com.springtutorial.springwebapp.services;

import com.springtutorial.springwebapp.domain.Book;

public interface BookService {

    Iterable<Book> findAll();

}
