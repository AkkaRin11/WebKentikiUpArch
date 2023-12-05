package org.kentiki.repository;

import io.minio.*;
import io.minio.errors.*;
import io.minio.messages.Item;
import lombok.RequiredArgsConstructor;
import org.kentiki.util.FileUtils;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Repository
@RequiredArgsConstructor
public class FileRepositoryImpl implements FileRepository{
    private final MinioClient minioClient;

    @Override
    public void downloadFiles() {

        // переписать бы
        try {
            Iterable<Result<Item>> list = minioClient.listObjects(ListObjectsArgs.builder()
                    .bucket(FileUtils.getBucketName())
                    .build());

            list.forEach(itemResult -> {
                try {
                    minioClient.downloadObject(DownloadObjectArgs.builder().
                    bucket(FileUtils.getBucketName())
                    .object(itemResult.get().objectName())
                    .filename(FileUtils.getImgPath() + itemResult.get().objectName())
                    .build());
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            });
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void deleteAllFiles() {
        Iterable<Result<Item>> list = minioClient.listObjects(ListObjectsArgs.builder()
                .bucket(FileUtils.getBucketName())
                .build());

        list.forEach(itemResult -> {
            try {
                minioClient.removeObject(RemoveObjectArgs.builder()
                        .bucket(FileUtils.getBucketName())
                        .object(itemResult.get().objectName())
                        .build());
            } catch (Exception e) {
                System.out.println(e);
            }
        });
    }
}
