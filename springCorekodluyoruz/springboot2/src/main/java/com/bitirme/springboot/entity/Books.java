package com.bitirme.springboot.entity;


import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "books")
public class Books {

    @Id
    @Column(name = "bookno")
    private Long bookno;

    @Column(name = "bookname")
    private String bookname;

    @Column(name = "booktitle")
    private String booktitle;

    @Column(name = "author")
    private String author;

    @Column(name = "book_aciklama")
    private String bookaciklama;

    @Column(name = "book_year")
    private String bookyear;

    @Column(name = "book_note")
    private String booknote;

   /* @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "books",
            joinColumns = { @JoinColumn(name = "book_no") },
            inverseJoinColumns =  { @JoinColumn(name = "auth_id") }
    )
    private List<Author> authors;*/

    @OneToMany(mappedBy = "books", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Author> authors;

    public Long getBookno() {
        return bookno;
    }
    //yorum
    public void setBookno(Long bookno) {
        this.bookno = bookno;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getBooktitle() {
        return booktitle;
    }

    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookaciklama() {
        return bookaciklama;
    }

    public void setBookaciklama(String bookaciklama) {
        this.bookaciklama = bookaciklama;
    }

    public String getBookyear() {
        return bookyear;
    }

    public void setBookyear(String bookyear) {
        this.bookyear = bookyear;
    }

    public String getBooknote() {
        return booknote;
    }

    public void setBooknote(String booknote) {
        this.booknote = booknote;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

}
