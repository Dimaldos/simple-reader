package ru.dimaldos.simplereader.booksservicedb.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.dimaldos.simplereader.booksservicedb.entity.Content;

@Repository
public interface ContentRepository extends CrudRepository<Content, Long> {

    @Query(value = "select co from Content co where co.id = (select ch.contentId from Chapter ch where ch.id = :id)")
    Content getContentByChapterId(Long id);

}
