package com.example.kaddem.services;

import com.example.kaddem.entities.Contrat;
import com.example.kaddem.entities.Equipe;
import com.example.kaddem.entities.Etudiant;
import com.example.kaddem.repositories.IEquipeRepository;
import com.example.kaddem.repositories.IEtudiantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class EquipeServices implements IEquipeServices{

    private final IEquipeRepository equipeRepository;
    private final IEtudiantRepository etudiantRepository;

    @Override
    public List<Equipe> retrieveAllEquipes() {
        List<Equipe> e = new ArrayList<>();
        equipeRepository.findAll().forEach(e::add);
        return e;
    }

    @Override
    public Equipe addEquipe(Equipe e) {
        return equipeRepository.save(e);
    }

    @Override
    public Equipe updateEquipe(Equipe e) {
        return equipeRepository.save(e);
    }

    @Override
    public Equipe retrieveEquipe(Integer idEquipe) {
        return equipeRepository.findById(idEquipe).orElse(null);
    }

    @Override
    public void removeEquipe(Integer idEquipe) {
        equipeRepository.deleteById(idEquipe);
    }

    @Override
    public Equipe addAndAsignEquipe(Equipe e) {
        equipeRepository.save(e);
        for (Etudiant et : e.getEtudiants()){
            if(et.getEquipes() == null){
                Set<Equipe> eq = new HashSet<>();
                eq.add(e);
                et.setEquipes(eq);
            }
            else {
                et.getEquipes().add(e);
            }
            etudiantRepository.save(et);
        }
        return e;
    }

    @Override
    public void faireEvoluerEquipes() {
        List<Equipe> equipes = retrieveAllEquipes();
        Date d = new Date();
        for(Equipe e : equipes){
            for(Etudiant et : e.getEtudiants()){
                for(Contrat c : et.getContrats()){
                    if(d.getYear()-c.getDateDebutContrat().getYear()>1){

                    }
                }

            }
        }
    }
}
