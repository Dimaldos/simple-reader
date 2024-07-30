package ru.dimaldos.simplereader.booksservicedb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.dimaldos.simplereader.booksservicedb.entity.Volume;

import java.util.List;

@Repository
public interface VolumeRepository extends CrudRepository<Volume, Long> {

    List<Volume> findVolumesByBook_id(Long book_id);

    Volume findVolumeById(Long volumeId);

}
