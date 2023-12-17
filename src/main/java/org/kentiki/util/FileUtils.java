package org.kentiki.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class FileUtils {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static String getCredentialsName(){
        try {
            Map<String, String> configs = mapper.readValue(
                    new File("src/main/java/org/kentiki/project_configs/s3_config.json"), Map.class);
            return configs.get("credentials_name");

        } catch (IOException e) {
            System.out.println(e);
        }

        return null;
    }

    public static String getCredentialsPass(){
        try {
            Map<String, String> configs = mapper.readValue(
                    new File("src/main/java/org/kentiki/project_configs/s3_config.json"), Map.class);
            return configs.get("credentials_pass");

        } catch (IOException e) {
            System.out.println(e);
        }

        return null;
    }

    public static String getBucketName(){
        try {
            Map<String, String> configs = mapper.readValue(
                    new File("src/main/java/org/kentiki/project_configs/s3_config.json"), Map.class);
            return configs.get("bucket_name");

        } catch (IOException e) {
            System.out.println(e);
        }

        return null;
    }

    public static String getImgPath(String name){
        try {
            Map<String, String> configs = mapper.readValue(
                    new File("src/main/java/org/kentiki/project_configs/s3_config.json"), Map.class);
            return configs.get("img_path") + configs.get("bucket_name") + "/" + name + ".jpg";

        } catch (IOException e) {
            System.out.println(e);
        }

        return null;
    }

}
