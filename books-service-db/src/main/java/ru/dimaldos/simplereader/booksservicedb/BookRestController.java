package ru.dimaldos.simplereader.booksservicedb;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.dimaldos.simplereader.booksservicedb.entity.Book;
import ru.dimaldos.simplereader.booksservicedb.entity.Chapter;
import ru.dimaldos.simplereader.booksservicedb.entity.Volume;
import ru.dimaldos.simplereader.booksservicedb.service.BookService;
import ru.dimaldos.simplereader.booksservicedb.service.ChapterService;
import ru.dimaldos.simplereader.booksservicedb.service.VolumeService;

@RestController
@RequiredArgsConstructor
@RequestMapping("db/books")
public class BookRestController {

    private final BookService bookService;
    private final VolumeService volumeService;
    private final ChapterService chapterService;

    @GetMapping
    public Iterable<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("{bookId:\\d+}")
    public Book getBook(@PathVariable(name = "bookId") long bookId) {
        return bookService.getBookById(bookId);
    }

    @GetMapping("{bookId:\\d+}/volumes")
    public Iterable<Volume> getVolumesByBookId(@PathVariable(name = "bookId") long bookId) {
        return volumeService.findVolumesByBook_id(bookId);
    }

    @GetMapping("{bookId:\\d+}/volumes/{volumeId:\\d+}")
    public Volume getVolumeByVolumeId(@PathVariable(name = "volumeId") long volumeId) {
        return volumeService.findVolumeById(volumeId);
    }

    @GetMapping("{bookId:\\d+}/volumes/{volumeId:\\d+}/chapters")
    public Iterable<Chapter> getChaptersByVolumeId(@PathVariable(name = "volumeId") long volumeId) {
        return chapterService.findChaptersByVolumeId(volumeId);
    }

    @GetMapping("{bookId:\\d+}/volumes/{volumeId:\\d+}/chapters/{chapterId:\\d+}")
    public Chapter getChapterById(@PathVariable(name = "chapterId") long chapterId) {
        return chapterService.findChapterById(chapterId);
    }

}
