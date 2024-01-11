package com.example.datacenter.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class VirtualMachine implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idVm;

    String os;

    Integer tailleDisque;

    @Enumerated(EnumType.STRING)
    Etat etat;

    @ManyToOne
    Datacenter datacenter;
}
