package com.bookcatalogue.controller;

import com.bookcatalogue.domain.Author;
import com.bookcatalogue.service.author.AuthorService;
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
public class AuthorModifyController {

    @Autowired
    AuthorService authorService;

    private Author author;

    @RequestMapping(value = "update_author={id}", method = RequestMethod.GET)
    public String goToAuthorModifyPage(@PathVariable("id") Integer authorId, Model model){
        author = authorService.getAuthor(authorId);
        model.addAttribute(author);
        return "author_modify";
    }

    //@RequestMapping(method = RequestMethod.POST)
    public String authorModifyMethod(){
        //authorService.updateAuthor(author);
        return "author_modify";
    }
}
