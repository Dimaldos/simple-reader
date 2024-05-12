package ru.dimaldos.simplereader.booksservicedb.service;

import ru.dimaldos.simplereader.booksservicedb.entity.Book;

public interface BookService {

    Book getBookById(Long id);

}
