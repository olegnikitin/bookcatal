package com.bookcatalogue.controller;

import com.bookcatalogue.domain.Author;
import com.bookcatalogue.service.author.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by яна on 02.10.14.
 */
@Controller
@RequestMapping("/create_author")
public class AuthorCreateController {

    @Autowired
    AuthorService authorService;

    @RequestMapping(method = RequestMethod.GET)
    public String goToCreateAuthorPage(Model model){
        model.addAttribute(new Author());
        return "create_author";
    }

    //TODO: write this method
    @RequestMapping(method = RequestMethod.POST)
    public String createAuthorMethod(Author author, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "create_author" + "?has_errors"; //TODO: реализовать проверку
        }
        authorService.addAuthor(author);
        return "redirect:/create_author";
    }
}
