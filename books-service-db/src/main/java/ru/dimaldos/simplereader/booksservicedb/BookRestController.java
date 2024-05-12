package ru.dimaldos.simplereader.booksservicedb;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.dimaldos.simplereader.booksservicedb.entity.Book;
import ru.dimaldos.simplereader.booksservicedb.service.BookService;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/books")
public class BookRestController {

    private final BookService bookService;

    @GetMapping("{bookId:\\d+}")
    public Book getBook(@PathVariable(name = "bookId") long bookId) {
        return bookService.getBookById(bookId);
    }
}
