package com.bookcatalogue.controller;

import com.bookcatalogue.domain.Book;
import com.bookcatalogue.service.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    private Book book;
    private Integer id;

    //TODO:Write this method
    @RequestMapping("list_of_books/book_modify?={id}")
    public String goToModifyBookPage(Model model, @PathVariable("id") Integer id){
        model.addAttribute(model);
        this.id = id;
        this.book = bookService.getBookByID(id);
        return "book_modify";
    }

    //TODO:Write this method. Method POST
    //@RequestMapping(method = RequestMethod.POST)
    public String modifyBook(){

        return "list_of_books/book_modify?=" + id;
    }
}
