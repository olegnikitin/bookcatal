package com.bookcatalogue.controller;

import com.bookcatalogue.domain.Book;
import com.bookcatalogue.service.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by яна on 02.10.14.
 */
@Controller
public class ModifyBookController {

    @Autowired
    BookService bookService;

    @RequestMapping(value = "book_modify={id}", method = RequestMethod.GET)
    public String goToModifyBookPage(Model model, @PathVariable("id") Integer id){
        //Book book = bookService.getBookByID(id);

        Book book = bookService.listOfBook().get(id);
        model.addAttribute(book);
        return "book_modify";
    }

    @RequestMapping(value = "book_modify={id}", method = RequestMethod.POST)
    public String modifyBook(@PathVariable("id") Integer id, Book book, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "book_modify" + "?has_errors"; //TODO: реализовать проверку
        }
        bookService.updateBook(book);
        return "book_modify";
    }
}
