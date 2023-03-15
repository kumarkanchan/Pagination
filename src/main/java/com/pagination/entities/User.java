package com.pagination.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDate;

@Entity
@Table(name = "user_table")
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    @NotEmpty(message = "Name can't be null")
    private String name;

    @Column(name = "age")
    @NotNull(message = "Age can't be null")
    private Integer age;

    @Column(name = "date_of_birth")
    @Past(message = "DOB has only past date")
    private LocalDate dob;

    public User(String name, Integer age, LocalDate dob) {
        super();
        this.name = name;
        this.age = age;
        this.dob = dob;
    }
}
