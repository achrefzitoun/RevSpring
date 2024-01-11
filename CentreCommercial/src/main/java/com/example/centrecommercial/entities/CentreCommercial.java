package com.example.centrecommercial.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CentreCommercial implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;

    String nom;
    String adresse;
    String login;
    String password;

    @OneToMany(mappedBy = "centreCommercial")
    Set<Boutique> boutiques;
}
