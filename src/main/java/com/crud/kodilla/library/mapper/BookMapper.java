package com.crud.kodilla.library.mapper;

import com.crud.kodilla.library.domain.Book;
import com.crud.kodilla.library.domain.BookDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookMapper {
    public Book mapToBook(final BookDto bookDto) {
        return new Book(
                bookDto.getId(),
                bookDto.getTitleId(),
                bookDto.getTitle(),
                bookDto.getAuthor(),
                bookDto.getYearOfPublishing());
    }

    public BookDto mapToBookDto (final Book book) {
        return new BookDto(
                book.getId(),
                book.getTitleId(),
                book.getTitle(),
                book.getAuthor(),
                book.getYearOfPublishing());
    }

    public List<BookDto> mapToBookDtoList (final List<Book> bookList) {
        return bookList.stream()
                .map(book -> new BookDto(book.getId(),book.getTitleId(), book.getTitle(), book.getAuthor(), book.getYearOfPublishing()))
                .collect(Collectors.toList());
    }
}
