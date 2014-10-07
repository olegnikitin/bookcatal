package com.bookcatalogue.dao.book;

import com.bookcatalogue.domain.Author;
import com.bookcatalogue.domain.Book;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by яна on 25.09.14.
 */
@Repository
public class BookDAOImpl implements BookDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void addBook(Book book) {
        sessionFactory.getCurrentSession().save(book);
    }

    @Override
    @Transactional
    public Book getBookByID(Integer id) {
        return (Book)sessionFactory.getCurrentSession().load(Book.class, id);
    }

    @Override
    @Transactional
    public List getBooksByName(String nameOfBook) {
        Query q = sessionFactory.getCurrentSession().createQuery("from Book b where b.NAMEOFBOOK = :name");
        q.setString("name", nameOfBook);
        return q.list();
    }

    @Override
    @Transactional
    @SuppressWarnings("unchecked")
    public List<Book> listOfBook() {
        return (List)sessionFactory.getCurrentSession().createQuery("from Book").list();
    }

    @Override
    @Transactional
    public void removeBook(Integer id) {
        sessionFactory.getCurrentSession().delete(getBookByID(id));
    }

    @Override
    @Transactional
    public void updateBook(Book book) {
        sessionFactory.getCurrentSession().update(book);
    }
}
