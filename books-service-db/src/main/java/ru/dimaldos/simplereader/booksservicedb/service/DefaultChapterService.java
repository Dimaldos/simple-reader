package ru.dimaldos.simplereader.booksservicedb.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dimaldos.simplereader.booksservicedb.entity.Chapter;
import ru.dimaldos.simplereader.booksservicedb.repository.ChapterRepository;

@Service
@RequiredArgsConstructor
public class DefaultChapterService implements ChapterService {

    private final ChapterRepository chapterRepository;

    @Override
    public Iterable<Chapter> findChaptersByVolumeId(Long bookId) {
        return chapterRepository.findChaptersByVolume_Id(bookId);
    }

    @Override
    public Chapter findChapterById(Long chapterId) {
        return chapterRepository.findChapterById(chapterId);
    }

}
