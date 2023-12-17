package org.kentiki.repository;

import io.minio.*;
import lombok.RequiredArgsConstructor;
import org.kentiki.util.FileUtils;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Repository
@RequiredArgsConstructor
public class FileRepositoryImpl implements FileRepository{
    private final MinioClient minioClient;

//    @Override
//    public void downloadFiles() {
//
//        // переписать бы
//        try {
//            Iterable<Result<Item>> list = minioClient.listObjects(ListObjectsArgs.builder()
//                    .bucket(FileUtils.getBucketName())
//                    .build());
//
//            list.forEach(itemResult -> {
//                try {
//                    minioClient.downloadObject(DownloadObjectArgs.builder().
//                    bucket(FileUtils.getBucketName())
//                    .object(itemResult.get().objectName())
//                    .filename(FileUtils.getImgPath() + itemResult.get().objectName())
//                    .build());
//                } catch (Exception ex) {
//                    System.out.println(ex);
//                }
//            });
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }

//    @Override
//    public void deleteAllFiles() {
//        Iterable<Result<Item>> list = minioClient.listObjects(ListObjectsArgs.builder()
//                .bucket(FileUtils.getBucketName())
//                .build());
//
//        list.forEach(itemResult -> {
//            try {
//                minioClient.removeObject(RemoveObjectArgs.builder()
//                        .bucket(FileUtils.getBucketName())
//                        .object(itemResult.get().objectName())
//                        .build());
//            } catch (Exception e) {
//                System.out.println(e);
//            }
//        });
//    }

    @Override
    public void uploadFile(MultipartFile file) {
        byte[] bytes = new byte[0];
        try {
            bytes = file.getBytes();
        } catch (IOException e) {
            System.out.println(e);
        }

        try {
            ByteArrayInputStream byteA = new ByteArrayInputStream(bytes);

            minioClient.putObject(new PutObjectArgs().builder()
                    .bucket(FileUtils.getBucketName())
                    .object(file.getOriginalFilename()).
                    stream(byteA, bytes.length, -1)
                    .contentType("image/jpg").build());

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
