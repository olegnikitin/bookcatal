package com.bookcatalogue.service.author;

import com.bookcatalogue.dao.author.AuthorDAO;
import com.bookcatalogue.domain.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by яна on 25.09.14.
 */
@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorDAO authorDAO;

    @Override
    public void addAuthor(Author author) {
        authorDAO.addAuthor(author);
    }

    @Override
    public Author getAuthor(Integer id) {
        return authorDAO.getAuthor(id);
    }

    @Override
    public List<Author> listOfAuthors() {
        return authorDAO.listOfAuthors();
    }

    @Override
    public void removeAuthor(Integer id) {
        authorDAO.removeAuthor(id);
    }

    @Override
    public void updateAuthor(Author author) {
        authorDAO.updateAuthor(author);
    }
}
