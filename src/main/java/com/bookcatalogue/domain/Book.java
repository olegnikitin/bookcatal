package com.bookcatalogue.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Oleg Nikitin on 25.09.14.
 */
@Entity
@Table(name = "BOOKS")
public class Book implements Serializable{

    static final long serialVersionUID = 7347686825650215276L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAMEOFBOOK")
    @NotNull
    private String nameOfBook;

    @Column(name = "SHORTDESCRIPTION")
    @NotNull
    private String shortDescription;

    @Column(name = "YEAROFPUBLISHING", length = 4)
    @NotNull
    private Integer yearOfPublishing;

    @ManyToMany
    @JoinTable(name = "BOOKS_AUTHORS", joinColumns = @JoinColumn(name = "BOOK_ID"), inverseJoinColumns = @JoinColumn(name = "AUTHOR_ID"))
    private Set<Author> authors = new HashSet<>();

    public Book() {    }

    public String getNameOfBook() {
        return nameOfBook;
    }

    public void setNameOfBook(String nameOfBook) {
        this.nameOfBook = nameOfBook;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public Integer getYearOfPublishing() {
        return yearOfPublishing;
    }

    public void setYearOfPublishing(Integer yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (id != null ? !id.equals(book.id) : book.id != null) return false;
        if (nameOfBook != null ? !nameOfBook.equals(book.nameOfBook) : book.nameOfBook != null) return false;
        if (shortDescription != null ? !shortDescription.equals(book.shortDescription) : book.shortDescription != null)
            return false;
        if (yearOfPublishing != null ? !yearOfPublishing.equals(book.yearOfPublishing) : book.yearOfPublishing != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nameOfBook != null ? nameOfBook.hashCode() : 0);
        result = 31 * result + (shortDescription != null ? shortDescription.hashCode() : 0);
        result = 31 * result + (yearOfPublishing != null ? yearOfPublishing.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", nameOfBook='" + nameOfBook + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", yearOfPublishing=" + yearOfPublishing +
                '}';
    }
}
