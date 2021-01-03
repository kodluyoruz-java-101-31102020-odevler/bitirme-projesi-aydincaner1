package com.bitirme.springboot.controller;

import com.bitirme.springboot.entity.Books;
import com.bitirme.springboot.model.BookContext;
import com.bitirme.springboot.repository.BookRepository;
import com.bitirme.springboot.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/page")
public class BookController {

    @Autowired
    private BookServiceImpl bookService;

    @RequestMapping(value = "/ara", method = RequestMethod.POST)
    public String searchBook(BookContext bookContext, BindingResult result, Model model) {
    	
    	List<Books> books = bookService.searchBook(bookContext);
    	List<Books> bookss = bookService.searchName(bookContext);
    	
        model.addAttribute("books", books);
        model.addAttribute("bookss", bookss); 
        return "booklist";
    }
    

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getBooks(Model model) {

        List<Books> books = bookService.getAllBooksList();
        model.addAttribute("books", books);
        return "booklist";
        //yorum satır
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getBooksSavePage(BookContext bookContext) {

        return "save";
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String save(BookContext bookContext, BindingResult result, Model model) {

        bookService.save(bookContext);

        model.addAttribute("books", bookService.getAllBooksList());

        return "booklist";
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public String delete(Long id) {

        bookService.delete(id);
        return "booklist";
    }
}
