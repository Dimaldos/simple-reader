package ru.dimaldos.simplereader.booksservicedb.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dimaldos.simplereader.booksservicedb.entity.Book;
import ru.dimaldos.simplereader.booksservicedb.repository.BookRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public Book getBookById(Long id) {
        return bookRepository.findBookById(id);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
