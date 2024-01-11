package com.example.kaddem.services;

import com.example.kaddem.entities.Equipe;

import java.util.List;

public interface IEquipeServices {
    List<Equipe> retrieveAllEquipes();

    Equipe addEquipe(Equipe e); // ajouter l’équipe avec son détail

    Equipe updateEquipe (Equipe e);

    Equipe retrieveEquipe (Integer idEquipe);

    void removeEquipe(Integer idEquipe);

    Equipe addAndAsignEquipe(Equipe e);

    void faireEvoluerEquipes();
}
