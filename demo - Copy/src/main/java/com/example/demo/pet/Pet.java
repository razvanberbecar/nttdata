package com.example.demo.pet;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Pet {

    @Id
    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    private Long id;
    private String name;
    private String owner;
    private String type;
    private String race;
    private Integer realAge;
    @Transient
    private Integer humanAge;

    public Pet(){}

    public Pet(Long id, String name, String owner, String type, String race, Integer realAge) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.type = type;
        this.race = race;
        this.realAge = realAge;
    }

    public Pet(String name, String owner, String type, String race, Integer realAge) {
        this.name = name;
        this.owner = owner;
        this.type = type;
        this.race = race;
        this.realAge = realAge;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String email) {
        this.owner = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String dob) {
        this.type = dob;
    }

    public String getRace() {return race;}

    public void setRace(String race) {this.race = race;}

    public Integer getRealAge() {return realAge;}

    public void setRealAge(Integer realAge) {this.realAge = realAge;}

    public Integer getHumanAge() {
        return this.realAge*4;
    }

    public void setHumanAge(Integer humanAge) {
        this.humanAge = humanAge;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", owner='" + owner + '\'' +
                ", type=" + type +
                ", race=" + race +
                ", realAge=" + realAge +
                ", humanAge=" + humanAge +
                '}';
    }
}
