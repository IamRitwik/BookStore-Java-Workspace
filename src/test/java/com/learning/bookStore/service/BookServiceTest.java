package com.learning.bookStore.service;

import com.learning.bookStore.dto.BookDto;
import com.learning.bookStore.model.Book;
import com.learning.bookStore.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @Mock
    private ModelMapper mapper;

    @Test
    public void shouldReturnListOfBookDtoWhenGetBooksCalled() {
        List<Book> books = new ArrayList<>();
        Book book = getBook();
        books.add(book);
        BookDto bookDto = getBookDto();
        when(bookRepository.findAll()).thenReturn(books);
        when(mapper.map(book, BookDto.class)).thenReturn(bookDto);
        List<BookDto> bookDtos = bookService.getBooks();
        assertThat(1).isEqualTo(bookDtos.size());
        assertThat(bookDtos.get(0))
                .isNotNull()
                .hasFieldOrPropertyWithValue("title", "Test Title")
                .hasFieldOrPropertyWithValue("description", "Test Description")
                .hasFieldOrPropertyWithValue("releaseYear", 2024);
    }

    private Book getBook(){
        return Book.builder()
                .title("Test Title")
                .description("Test Description")
                .id(UUID.randomUUID())
                .releaseYear(2024)
                .build();
    }

    private BookDto getBookDto(){
        return BookDto.builder()
                .title("Test Title")
                .description("Test Description")
                .id(UUID.randomUUID())
                .releaseYear(2024)
                .build();
    }
}
