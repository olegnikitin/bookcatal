package com.bookcatalogue.controller;

import com.bookcatalogue.domain.Book;
import com.bookcatalogue.service.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * Created by яна on 01.10.14.
 */
@Controller
public class ListOfBooksController {

    @Autowired
    private BookService bookService;

    @RequestMapping("list_of_books")
    public String listOfBooks(Map<String, Object> map){
        map.put("book", new Book());
        map.put("listBook", bookService.listOfBook());
        return "list_of_books";
    }

    @RequestMapping("delete_book={id}")
    public String deleteBook(@PathVariable("id") Integer authorId){
        bookService.removeBook(authorId);
        return "redirect:/list_of_books";
    }

    @RequestMapping("update_book={id}")
    public String updateBook(@PathVariable("id") Integer authorId){
        return "update_book?id=" + authorId;
    }

    //TODO:Write the method below and the request to DB
    @RequestMapping("books_of_author?searched_book_name={name}")
    public String searchBook(@PathVariable("name") String name){
        bookService.getBookByName(name);
        return "books_of_author?=" + name;
    }
}