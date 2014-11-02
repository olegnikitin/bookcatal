package com.bookcatalogue.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by яна on 25.09.14.
 */
@Entity
@Table(name = "AUTHORS")
public class Author implements Serializable{

    static final long serialVersionUID = 6325259330304883780L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "FIRSTNAME")
    @NotNull
    private String firstName;

    @Column(name = "LASTNAME")
    @NotNull
    private String lastName;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "BOOKS")
    @JoinTable(name = "BOOKS_AUTHORS",
            joinColumns = @JoinColumn(name = "AUTHOR_ID", referencedColumnName="ID"),
            inverseJoinColumns = @JoinColumn(name = "BOOK_ID", referencedColumnName="ID"))
    private Set<Book> books = new HashSet<>();

    public Author() {    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        if (firstName != null ? !firstName.equals(author.firstName) : author.firstName != null) return false;
        if (lastName != null ? !lastName.equals(author.lastName) : author.lastName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Author{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
