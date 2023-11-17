package com.springtutorial.springwebapp.controllers;

import com.springtutorial.springwebapp.services.BookService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class BookController {
    // notice we use the interface not the implementation.
    // by doing this we can later use multiple implementations(DI)
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/books")
    public String getBooks(Model model) {

        model.addAttribute("books", bookService.findAll());
        return "books";
    }

}
