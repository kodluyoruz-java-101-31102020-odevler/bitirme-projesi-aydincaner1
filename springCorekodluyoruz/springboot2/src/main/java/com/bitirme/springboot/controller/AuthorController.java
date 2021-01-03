package com.bitirme.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitirme.springboot.entity.Books;
import com.bitirme.springboot.model.BookContext;
import com.bitirme.springboot.service.BookServiceImpl;

@Controller
@RequestMapping("/page")
public class AuthorController {
	

	@Autowired
	//	tekrar yazar olarak 3 ayrı class yaratmamak için book implementasyonları yazarlar icin kullanıldı
    private BookServiceImpl bookService;

    @RequestMapping(value = "/authara", method = RequestMethod.POST)
    public String searchAuthName(BookContext bookContext, BindingResult result, Model model) {
    	
    	List<Books> books = bookService.searchAuthName(bookContext);
    	
        model.addAttribute("books", books); 
        return "authorlist";
        //yorum
    }
    

    @RequestMapping(value = "/authlist", method = RequestMethod.GET)
    public String getBooks(Model model) {

        List<Books> books = bookService.getAllBooksList();
        model.addAttribute("books", books);
        return "authorlist";
    }

}
