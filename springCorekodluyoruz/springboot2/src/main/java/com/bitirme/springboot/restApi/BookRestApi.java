package com.bitirme.springboot.restApi;

import java.awt.print.Book;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bitirme.springboot.entity.Books;
import com.bitirme.springboot.model.BookContext;
import com.bitirme.springboot.service.BookServiceImpl;

@RestController
@RequestMapping("/restapi")
public class BookRestApi {
	
	@Autowired
	private BookServiceImpl bookServiceImpl;

	// http://localhost:8080/restapi/book/5 ile test edildii.
	@RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
	public Books findByBkNo(@PathVariable("id") Long id) {
		return bookServiceImpl.findWithId(id);
	}
	
	// http://localhost:8080/restapi/listbook ile test edilip postman üzerinden data test edildi.
	@RequestMapping(value = "/listbook", method = RequestMethod.GET)
	public List<Books> getAllBookList() {
		return bookServiceImpl.getAllBooksList();
	}
	//yorum
	@RequestMapping(value = "/savebook", method = RequestMethod.POST)
	public void saveBook(@RequestBody BookContext Books) {
		bookServiceImpl.save(Books);

	}
	@RequestMapping(value = "/updatebook/{id}", method = RequestMethod.PUT)
	public void updateBook(@RequestBody BookContext Books) {

		bookServiceImpl.update(Books);
	}

	// http://localhost:8080/restapi/deletebook/3 test edilip 3. kayit silindi.
	@RequestMapping(value = "/deletebook/{id}", method = RequestMethod.DELETE)
	public void deleteBook(@PathVariable("id") Long id) {
		bookServiceImpl.delete(id);
	}

}
