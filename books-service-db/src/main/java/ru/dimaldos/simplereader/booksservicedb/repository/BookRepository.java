package ru.dimaldos.simplereader.booksservicedb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dimaldos.simplereader.booksservicedb.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Book findBookById(Long id);

}
