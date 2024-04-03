package com.learning.bookStore.controller;

import java.util.List;

import com.learning.bookStore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.learning.bookStore.dto.BookDto;


@RestController
@RequestMapping("api/v1/books")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping()
	public ResponseEntity<List<BookDto>> getBooks(){
		List<BookDto> books = this.bookService.getBooks();
		return ResponseEntity.ok(books);
		
	}

}
