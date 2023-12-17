package org.kentiki.servise;

import lombok.RequiredArgsConstructor;
import org.kentiki.repository.FileRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {
    private final FileRepository fileRepository;

//    @Override
//    public void updateFiles() {
//        fileRepository.downloadFiles();
//        fileRepository.deleteAllFiles();
//    }

    @Override
    public void upload(MultipartFile file) {
        fileRepository.uploadFile(file);
    }
}
