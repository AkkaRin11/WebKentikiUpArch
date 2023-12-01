package org.kentiki.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.kentiki.domain.Img;
import org.kentiki.domain.User;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ImgDto {
    private String name;
    private String date;
    private String userName;

    public static ImgDto toDto(Img img){
        return new ImgDto(
                img.getName(),
                img.getDate(),
                img.getUserName()
        );
    }

    public static Img toDomainObject(ImgDto imgDto){
        return new Img(
                imgDto.getName(),
                imgDto.getDate(),
                imgDto.getUserName()
        );
    }
}
