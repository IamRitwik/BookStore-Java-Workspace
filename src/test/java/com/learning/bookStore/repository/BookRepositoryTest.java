package com.learning.bookStore.repository;

import java.util.List;
import java.util.stream.StreamSupport;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.learning.bookStore.model.Book;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookRepositoryTest {
	
	@Autowired
	private BookRepository bookRepository;

	@Test
	@Sql(scripts = {"classpath:InsertInitialBookrecordsForTest.sql"})
	public void shouldAbleToFetchAllBooksInDb() {
		Iterable<Book> allBooks = bookRepository.findAll();
		long totalBookCount = StreamSupport.stream(allBooks.spliterator(), false).count();
		Assertions.assertEquals(totalBookCount, 2);
	}

	@Test
	@Sql(scripts = {"classpath:InsertInitialBookrecordsForTest.sql"})
	public void shouldReturnOneBookWhenTitleIsTestTitle(){
		List<Book> testTitle = bookRepository.findBooksByTitle("Test Title");
		Assertions.assertEquals(testTitle.size(), 1);
	}

}
