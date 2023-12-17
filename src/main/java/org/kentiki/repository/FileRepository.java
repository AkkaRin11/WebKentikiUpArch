package org.kentiki.repository;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository
public interface FileRepository {
//    void downloadFiles();

//    void deleteAllFiles();

    void uploadFile(MultipartFile file);
}
