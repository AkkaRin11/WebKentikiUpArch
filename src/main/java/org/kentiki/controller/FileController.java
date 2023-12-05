package org.kentiki.controller;

import lombok.RequiredArgsConstructor;
import org.kentiki.servise.FileService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FileController {
    private final FileService fileService;

    @GetMapping("/file")
    public void updateFiles(){
        fileService.updateFiles();
    }
}
