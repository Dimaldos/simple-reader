package ru.dimaldos.simplereader.booksservicedb.service;

import ru.dimaldos.simplereader.booksservicedb.entity.Chapter;

public interface ChapterService {

    Iterable<Chapter> findChaptersByVolumeId(Long bookId);

    Chapter findChapterById(Long chapterId);
}
