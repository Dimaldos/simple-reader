package ru.dimaldos.simplereader.booksservicedb.service;

import ru.dimaldos.simplereader.booksservicedb.entity.Volume;

public interface VolumeService {

    Iterable<Volume> findVolumesByBook_id(Long book_id);

    Volume findVolumeById(Long volumeId);

}
