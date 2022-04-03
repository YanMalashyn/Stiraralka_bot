package com.example.stiraralka_bot.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Table(name = "paha_phrase")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PahaPhraze extends AbstractBaseEntity {


    @Column(name = "name", unique = true, nullable = false)
    @NotBlank
    private String name;


    public PahaPhraze(Integer id, @NotBlank String name) {
        super(id);
        this.name = name;
    }

}
