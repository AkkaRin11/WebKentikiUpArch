package org.kentiki.servise;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
//    void updateFiles();

    void upload(MultipartFile file);
}
