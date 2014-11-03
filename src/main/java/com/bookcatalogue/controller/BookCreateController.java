package com.bookcatalogue.controller;

import com.bookcatalogue.domain.Book;
import com.bookcatalogue.service.author.AuthorService;
import com.bookcatalogue.service.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * Created by яна on 02.10.14.
 */
@Controller
public class BookCreateController {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @RequestMapping(value = "create_book", method = RequestMethod.GET)
    public String goToBookCreatePage(Map<String, Object> map){
        map.put("book", new Book());
        map.put("authorList", authorService.listOfAuthors());
        return "create_book";
    }

    @RequestMapping(value = "create_book", method = RequestMethod.POST)
    public String createBookMethod(Book book, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "create_book" + "?has_errors"; //TODO: реализовать проверку
        }
        bookService.addBook(book);
        return "redirect:/create_book";
    }
}
