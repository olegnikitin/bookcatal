package com.bookcatalogue.controller;

import com.bookcatalogue.domain.Author;
import com.bookcatalogue.service.author.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

/**
 * Created by яна on 25.09.14.
 */
@Controller
public class ListOfAuthorsController {

    @Autowired
    private AuthorService authorService;

    @RequestMapping("/list_of_authors")
    public String authorsList(Map<String, Object> map){
        map.put("author", new Author());
        map.put("authorsList", authorService.listOfAuthors());
        return "list_of_authors";
    }

    @RequestMapping("/books_of_author={id}")// TODO: remove this method and create controller for them
    public String authorsListOfBooks(@PathVariable("id") Integer authorId){
        return "books_of_author?id=" + authorId;
    }

    @RequestMapping("delete_author={id}")
    public String deleteAuthor(@PathVariable("id") Integer authorId) {
        authorService.removeAuthor(authorId);
        return "redirect:/list_of_authors";
    }

}
