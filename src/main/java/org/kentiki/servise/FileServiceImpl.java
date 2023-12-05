package org.kentiki.servise;

import lombok.RequiredArgsConstructor;
import org.kentiki.repository.FileRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {
    private final FileRepository fileRepository;

    @Override
    public void updateFiles() {
        fileRepository.downloadFiles();
        fileRepository.deleteAllFiles();
    }
}
