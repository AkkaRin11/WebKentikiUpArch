package org.kentiki.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository {
    void downloadFiles();

    void deleteAllFiles();
}
