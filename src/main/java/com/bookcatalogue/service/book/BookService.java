package com.bookcatalogue.service.book;

import com.bookcatalogue.domain.Author;
import com.bookcatalogue.domain.Book;

import java.util.List;

/**
 * Created by яна on 25.09.14.
 */
public interface BookService {
    public void addBook(Book book);//#5
    public Book getBookByID(Integer id);
    public Book getBookByName(String nameOfBook);//#4
    //public List<Book> getBooksByAuthor(Author author);//#3
    public List<Book> listOfBook();//#1
    public void removeBook(Integer id);//#9
    public void updateBook(Book book);//#8
}
