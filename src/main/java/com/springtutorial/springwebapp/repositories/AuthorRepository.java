package com.springtutorial.springwebapp.repositories;


import com.springtutorial.springwebapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
