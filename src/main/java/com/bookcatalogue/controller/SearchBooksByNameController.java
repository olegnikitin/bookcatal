package com.bookcatalogue.controller;

import com.bookcatalogue.domain.Book;
import com.bookcatalogue.service.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by яна on 04.10.14.
 */
@Controller
public class SearchBooksByNameController {

    @Autowired
    private BookService bookService;
    private Book book;//get data and set in fields

    @RequestMapping("books_of_author")
    public String goToBooksOfAuthorPage(){
        return "books_of_author";
    }

    @RequestMapping("searched_book_name={name}")
    public String searchByNameMethod(@PathVariable("name") String name, Model model){
        book = bookService.getBookByName(name);
        model.addAttribute(book);
        return "searched_book_name=" + name;
    }
}
