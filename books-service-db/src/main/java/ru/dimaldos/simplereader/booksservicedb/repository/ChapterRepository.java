package ru.dimaldos.simplereader.booksservicedb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.dimaldos.simplereader.booksservicedb.entity.Chapter;

import java.util.List;

@Repository
public interface ChapterRepository extends CrudRepository<Chapter, Long> {

    List<Chapter> findChaptersByVolume_Id(Long volumeId);

    Chapter findChapterById(Long chapterId);
}
