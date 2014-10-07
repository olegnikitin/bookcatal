package com.bookcatalogue.service.book;

import com.bookcatalogue.dao.book.BookDAO;
import com.bookcatalogue.domain.Author;
import com.bookcatalogue.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by яна on 25.09.14.
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDAO bookDAO;

    @Override
    public void addBook(Book book) {
        bookDAO.addBook(book);
    }

    @Override
    public Book getBookByID(Integer id) {
        return bookDAO.getBookByID(id);
    }

    @Override
    public Book getBookByName(String nameOfBook) {
        return bookDAO.getBookByName(nameOfBook);
    }

    @Override
    public List<Book> listOfBook() {
        return bookDAO.listOfBook();
    }

    @Override
    public void removeBook(Integer id) {
        bookDAO.removeBook(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDAO.updateBook(book);
    }
}
