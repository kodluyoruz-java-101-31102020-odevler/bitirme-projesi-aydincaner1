package com.bitirme.springboot.entity;

import javax.persistence.*;
import java.awt.print.Book;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "authors")

public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "auth_id")
    private Long authorid;

    @Column(name = "auth_name")
    private String authorname;

   /* @ManyToMany(mappedBy = "authors", fetch = FetchType.LAZY)
    private List<Books> books; */

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bookno")
    private Books books;

    public Long getAuthorid() {
        return authorid;
    }

    public void setAuthorid(Long authorid) {
        this.authorid = authorid;
    }

    public String getAuthorname() {
        return authorname;
    }

    public void setAuthorname(String authorname) {
        this.authorname = authorname;
    }
    //yorum
    public Books getBooks() {
        return books;
    }

    public void setBooks(Books books) {
        this.books = books;
    }
}
