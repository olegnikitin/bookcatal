package com.bookcatalogue.dao.author;

import com.bookcatalogue.domain.Author;

import java.util.List;

/**
 * Created by яна on 25.09.14.
 */
public interface AuthorDAO {
    public void addAuthor(Author author);//#6
    public Author getAuthor(Integer id);
    public List<Author> listOfAuthors();//#2
    public void removeAuthor(Integer id);//#10
    public void updateAuthor(Author author);//#7
}
