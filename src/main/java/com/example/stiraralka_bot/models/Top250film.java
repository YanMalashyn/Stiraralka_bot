package com.example.stiraralka_bot.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "top250_film")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Top250film extends AbstractBaseEntity {


    @Column(name = "name", unique = true, nullable = false)
    @NotBlank
    private String name;


    public Top250film(Integer id, @NotBlank String name) {
        super(id);
        this.name = name;
    }

}