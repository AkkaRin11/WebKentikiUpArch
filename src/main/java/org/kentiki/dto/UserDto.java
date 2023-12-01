package org.kentiki.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.kentiki.domain.User;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private int id;
    private String name;
    private int currentAction;

    public static UserDto toDto(User user){
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getCurrentAction()
        );
    }

    public static User toDomainObject(UserDto userDto){
        return new User(
                userDto.getId(),
                userDto.getName(),
                userDto.getCurrentAction()
        );
    }
}
