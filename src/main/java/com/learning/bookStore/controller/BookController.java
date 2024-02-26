package com.learning.bookStore.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.learning.bookStore.dto.BookDto;


@RestController
@RequestMapping("api/v1/books")
public class BookController {
	
	@GetMapping()
	public ResponseEntity<List<BookDto>> getBooks(){
		BookDto book = BookDto.builder()
				.title("Learn Core Java")
				.build();
		BookDto book2 = BookDto.builder()
				.title("Learn Spring Boot")
				.build();
		List<BookDto> books = new ArrayList<>();
		books.add(book);
		books.add(book2);
		return ResponseEntity.ok(books);
		
	}

}
