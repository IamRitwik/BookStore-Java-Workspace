package com.learning.bookStore.integration;

import com.learning.bookStore.BookStoreApplication;
import com.learning.bookStore.dto.BookDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest(classes = BookStoreApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BookControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @Sql(scripts = {"classpath:InsertInitialBookrecordsForTest.sql"})
    public void shouldReturnBooksWhenBookApiCalled(){
        BookDto[] listOfBooks = restTemplate.getForObject("http://localhost:" + port + "/api/v1/books", BookDto[].class);
        Assertions.assertThat(listOfBooks).isNotNull();
        Assertions.assertThat(listOfBooks.length).isEqualTo(2);

    }

    @Test
    @Sql(scripts = {"classpath:InsertInitialBookrecordsForTest.sql"})
    public void shouldReturnBooksWhenBookApiCalled2(){
        BookDto[] listOfBooks = restTemplate.getForObject("http://localhost:" + port + "/api/v1/books", BookDto[].class);
        Assertions.assertThat(listOfBooks).isNotNull();
        Assertions.assertThat(listOfBooks.length).isEqualTo(2);

    }
}
