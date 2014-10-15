package com.bookcatalogue.controller;

import com.bookcatalogue.domain.Book;
import com.bookcatalogue.service.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by яна on 02.10.14.
 */
@Controller
public class BookCreateController {

    @Autowired
    BookService bookService;

    @RequestMapping(value = "/create_book")
    public String goToBookCreatePage(Model model){
        model.addAttribute(new Book());
        return "create_book";
    }

    @RequestMapping(value = "createBookMethod", method = RequestMethod.POST)
    public String createBookMethod(Book book, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "create_book" + "?has_errors"; //TODO: реализовать проверку
        }
        bookService.addBook(book);
        return "redirect:/create_book";
    }
}
