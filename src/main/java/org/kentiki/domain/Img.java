package org.kentiki.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "my_img")
public class Img {
    @Id
    private String name;

    @Column(name = "date")
    private String date;

    @Column(name = "user_name")
    private String userName;
}
