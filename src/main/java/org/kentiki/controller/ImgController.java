package org.kentiki.controller;

import lombok.RequiredArgsConstructor;
import org.kentiki.domain.User;
import org.kentiki.dto.ImgDto;
import org.kentiki.dto.UserDto;
import org.kentiki.servise.ImgService;
import org.kentiki.servise.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ImgController {
    private final ImgService imgService;

    @PostMapping("/img")
    public void insertImg(@RequestBody ImgDto imgDto){
        imgService.insert(ImgDto.toDomainObject(imgDto));
    }

    @GetMapping("/img/{name}")
    public ImgDto findImgByName(@PathVariable String name){
        return ImgDto.toDto(imgService.getByName(name));
    }

    @GetMapping("/img")
    public List<ImgDto> getAllImg(){
        return imgService
                .getAll()
                .stream()
                .map(ImgDto::toDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/img/{name}")
    public void updateImg(@PathVariable String name, @RequestParam String date, @RequestParam String userName){
        imgService.update(name, date, userName);
    }

    @DeleteMapping("/img/{name}")
    public void deleteImg(@PathVariable String name){
        imgService.deleteByName(name);
    }

}
