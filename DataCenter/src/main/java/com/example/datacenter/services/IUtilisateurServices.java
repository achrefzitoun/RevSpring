package com.example.datacenter.services;

import com.example.datacenter.entities.Datacenter;
import com.example.datacenter.entities.Utilisateur;
import com.example.datacenter.entities.VirtualMachine;

import java.util.List;

public interface IUtilisateurServices {
    public void ajouterUser(Utilisateur user);

    public void ajouterDc(Datacenter dc);

    public int ajouterVm(VirtualMachine vm);

    public void affecterVmUser(int idvm, int iduser);

    public void affecterVm(int idVm);

    public void demarrerInstanceUser(int idvm);

    public void arreterInstanceUser(int idvm);

    public List<Datacenter> listerDatacenter();
}
