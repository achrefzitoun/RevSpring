package com.example.centrecommercial.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Boutique implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;

    String nom;

    @Enumerated(EnumType.STRING)
    Categorie categorie;

    @ManyToOne
            @JsonIgnore
    CentreCommercial centreCommercial;

    @ManyToMany
            @JsonIgnore
    Set<Client> clients;
}
