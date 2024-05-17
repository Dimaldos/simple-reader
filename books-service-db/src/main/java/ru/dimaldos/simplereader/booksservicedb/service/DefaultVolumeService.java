package ru.dimaldos.simplereader.booksservicedb.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dimaldos.simplereader.booksservicedb.entity.Volume;
import ru.dimaldos.simplereader.booksservicedb.repository.VolumeRepository;

@Service
@RequiredArgsConstructor
public class DefaultVolumeService implements VolumeService {

    private final VolumeRepository volumeRepository;

    @Override
    public Iterable<Volume> findVolumesByBook_id(Long book_id) {
        return volumeRepository.findVolumesByBook_id(book_id);
    }

    @Override
    public Volume findVolumeById(Long volumeId) {
        return volumeRepository.findVolumeById(volumeId);
    }
}
