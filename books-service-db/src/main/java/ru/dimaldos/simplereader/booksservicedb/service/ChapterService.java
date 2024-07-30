package ru.dimaldos.simplereader.booksservicedb.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dimaldos.simplereader.booksservicedb.entity.Chapter;
import ru.dimaldos.simplereader.booksservicedb.entity.Content;
import ru.dimaldos.simplereader.booksservicedb.repository.ChapterRepository;
import ru.dimaldos.simplereader.booksservicedb.repository.ContentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChapterService {

    private final ChapterRepository chapterRepository;
    private final ContentRepository contentRepository;

    public List<Chapter> findChaptersByVolumeId(Long bookId) {
        return chapterRepository.findChaptersByVolume_Id(bookId);
    }

    public Chapter findChapterById(Long chapterId) {
        Chapter chapter = chapterRepository.findChapterById(chapterId);
        Content content = contentRepository.getContentByChapterId(chapterId);
        chapter.setContent(content.getContent());
        return chapter;
    }

}
