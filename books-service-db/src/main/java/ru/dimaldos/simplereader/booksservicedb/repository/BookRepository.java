package ru.dimaldos.simplereader.booksservicedb.repository;

import org.springframework.stereotype.Repository;
import ru.dimaldos.simplereader.booksservicedb.entity.Book;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    Book findBookById(Long id);

}
