package com.bitirme.springboot.service;

import com.bitirme.springboot.entity.Author;
import com.bitirme.springboot.entity.Books;
import com.bitirme.springboot.model.BookContext;

import java.util.List;

public interface IBookService {

    //layer
    public Books findWithId(Long id);
    public List<Books> getAllBooksList();
    public List<Author> getAllAuthorList();
    public List<Books> searchBook(BookContext booksContext);
    public List<Books> searchName(BookContext booksContext);
    public List<Books> searchAuthName(BookContext booksContext);
    public Long save(BookContext booksContext);
    public Long update(BookContext booksContext);
    public Long delete(Long id);
}
