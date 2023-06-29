package com.springtutorial.springwebapp.repositories;

import com.springtutorial.springwebapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
