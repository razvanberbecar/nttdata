package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class Pet {

    @Id
    @SequenceGenerator(
            name = "pet_sequence",
            sequenceName = "pet_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "pet_sequence"
    )

    private Long id;
    private String name;
    private String owner;
    private String type;
    private String race;
    private Integer realAge;

    public Pet(String name, String owner, String type, String race, Integer realAge) {
        this.name = name;
        this.owner = owner;
        this.type = type;
        this.race = race;
        this.realAge = realAge;
    }

    public Integer getHumanAge() {
        return this.realAge * 4;
    }


}
