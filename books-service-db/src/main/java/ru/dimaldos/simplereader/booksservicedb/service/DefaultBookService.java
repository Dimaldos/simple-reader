package ru.dimaldos.simplereader.booksservicedb.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dimaldos.simplereader.booksservicedb.entity.Book;
import ru.dimaldos.simplereader.booksservicedb.repository.BookRepository;

@Service
@RequiredArgsConstructor
public class DefaultBookService implements BookService {

    private final BookRepository bookRepository;

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findBookById(id);
    }

    @Override
    public Iterable<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
