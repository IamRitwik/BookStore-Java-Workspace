package com.learning.bookStore.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.learning.bookStore.model.Book;

public interface BookRepository extends CrudRepository<Book, UUID>{
	
	//List<Book> findBooksByTitleAndDescription(String title, String description);

}
