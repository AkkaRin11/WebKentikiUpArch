package org.kentiki.domain;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "my_user")
public class User {
    @Id
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "current_action")
    private int currentAction;
}
