package ru.dimaldos.simplereader.booksservicedb.repository;

import org.springframework.data.repository.CrudRepository;
import ru.dimaldos.simplereader.booksservicedb.entity.Chapter;

public interface ChapterRepository extends CrudRepository<Chapter, Long> {
}
