package org.kentiki.configuration;

import io.minio.MinioClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.kentiki.util.FileUtils;

@Configuration
public class S3Configuration {

    @Bean
    public MinioClient S3Client(){
        return MinioClient.builder()
                .endpoint("http://127.0.0.1:9000")
                .credentials(FileUtils.getCredentialsName(),
                        FileUtils.getCredentialsPass())
                .build();
    }
}
