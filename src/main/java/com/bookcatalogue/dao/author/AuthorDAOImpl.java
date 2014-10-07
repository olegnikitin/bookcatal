package com.bookcatalogue.dao.author;

import com.bookcatalogue.domain.Author;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by яна on 25.09.14.
 */
@Repository
public class AuthorDAOImpl implements AuthorDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void addAuthor(Author author) {
        sessionFactory.getCurrentSession().save(author);
    }

    @Override
    @Transactional
    public Author getAuthor(Integer id) {
        return (Author)sessionFactory.getCurrentSession().load(Author.class, id);
    }

    @Override
    @Transactional
    @SuppressWarnings("unchecked")
    public List<Author> listOfAuthors() {
        return (List)sessionFactory.getCurrentSession().createQuery("from Author").list();
    }

    @Override
    @Transactional
    public void removeAuthor(Integer id) {
        sessionFactory.getCurrentSession().delete(getAuthor(id));
    }

    @Override
    @Transactional
    public void updateAuthor(Author author) {
        sessionFactory.getCurrentSession().update(author);
    }
}
