package org.kentiki.controller;

import lombok.RequiredArgsConstructor;
import org.kentiki.dto.UserDto;
import org.kentiki.servise.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/user")
    public void insertUser(@RequestBody UserDto userDto){
        userService.insert(UserDto.toDomainObject(userDto));
    }

    @GetMapping("/user/{id}")
    public UserDto findUserById(@PathVariable int id){
        return UserDto.toDto(userService.getById(id));
    }

    @GetMapping("/user")
    public List<UserDto> getAllUser(){
        return userService
                .getAll()
                .stream()
                .map(UserDto::toDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/user/{id}")
    public void updateUser(@PathVariable int id, @RequestParam String name, @RequestParam int currentAction){
        userService.update(id, name, currentAction);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable int id){
        userService.deleteById(id);
    }

}
