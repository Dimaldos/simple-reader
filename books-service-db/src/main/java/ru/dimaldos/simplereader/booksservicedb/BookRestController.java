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

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("db/bookshelf")
public class BookRestController {

    private final BookService bookService;
    private final VolumeService volumeService;
    private final ChapterService chapterService;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("books/{bookId:\\d+}")
    public Book getBook(@PathVariable(name = "bookId") long bookId) {
        return bookService.getBookById(bookId);
    }

    @GetMapping("books/{bookId:\\d+}/volumes")
    public List<Volume> getVolumesByBookId(@PathVariable(name = "bookId") long bookId) {
        return volumeService.findVolumesByBook_id(bookId);
    }

    @GetMapping("volumes/{volumeId:\\d+}")
    public Volume getVolumeByVolumeId(@PathVariable(name = "volumeId") long volumeId) {
        return volumeService.findVolumeById(volumeId);
    }

    @GetMapping("volumes/{volumeId:\\d+}/chapters")
    public List<Chapter> getChaptersByVolumeId(@PathVariable(name = "volumeId") long volumeId) {
        return chapterService.findChaptersByVolumeId(volumeId);
    }

    @GetMapping("chapters/{chapterId:\\d+}")
    public Chapter getChapterById(@PathVariable(name = "chapterId") long chapterId) {
        return chapterService.findChapterById(chapterId);
    }

}
