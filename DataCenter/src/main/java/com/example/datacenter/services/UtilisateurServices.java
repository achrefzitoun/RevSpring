package com.example.datacenter.services;

import com.example.datacenter.entities.Datacenter;
import com.example.datacenter.entities.Etat;
import com.example.datacenter.entities.Utilisateur;
import com.example.datacenter.entities.VirtualMachine;
import com.example.datacenter.repositories.IDatacenterRepository;
import com.example.datacenter.repositories.IUtilisateurRepository;
import com.example.datacenter.repositories.IVirtualMachineRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class UtilisateurServices implements IUtilisateurServices{

    private final IUtilisateurRepository utilisateurRepository;
    private final IDatacenterRepository datacenterRepository;
    private final IVirtualMachineRepository virtualMachineRepository;
    @Override
    public void ajouterUser(Utilisateur user) {
        utilisateurRepository.save(user);
    }

    @Override
    public void ajouterDc(Datacenter dc) {
        datacenterRepository.save(dc);
    }

    @Override
    public int ajouterVm(VirtualMachine vm) {
        virtualMachineRepository.save(vm);
        return 1;
    }

    @Override
    public void affecterVmUser(int idvm, int iduser) {
        VirtualMachine vm = virtualMachineRepository.findById(idvm).orElse(null);
        Utilisateur user = utilisateurRepository.findById(iduser).orElse(null);
        if(user.getVirtualMachines()==null){
            Set<VirtualMachine> virtualMachines = new HashSet<>();
            virtualMachines.add(vm);
            user.setVirtualMachines(virtualMachines);
        }
        else {
            user.getVirtualMachines().add(vm);
        }
        utilisateurRepository.save(user);
    }

    @Override
    public void affecterVm(int idVm) {
        VirtualMachine vm = virtualMachineRepository.findById(idVm).orElse(null);
        List<Datacenter> datacenters = new ArrayList<>();
        datacenterRepository.findAll().forEach(datacenters::add);

        for(Datacenter dc : datacenters){
            if(dc.getEspaceLibreDisque()>vm.getTailleDisque()){
                dc.setEspaceLibreDisque(dc.getEspaceLibreDisque()-vm.getTailleDisque());
                datacenterRepository.save(dc);
                vm.setDatacenter(dc);
                virtualMachineRepository.save(vm);
                break;
            }
        }
    }

    @Override
    public void demarrerInstanceUser(int idvm) {
        VirtualMachine vm = virtualMachineRepository.findById(idvm).orElse(null);
        vm.setEtat(Etat.RUNNING);
        virtualMachineRepository.save(vm);
    }

    @Override
    public void arreterInstanceUser(int idvm) {
        VirtualMachine vm = virtualMachineRepository.findById(idvm).orElse(null);
        vm.setEtat(Etat.STOPPED);
        virtualMachineRepository.save(vm);
    }

    @Override
    @Scheduled(cron = "1/5 * * * * *")
    @Transactional
    public List<Datacenter> listerDatacenter() {
        System.out.println("_________________________________");
        List<Datacenter> datacenters = new ArrayList<>();

        Date d1 = new Date(2019,Calendar.NOVEMBER,1);

        datacenterRepository.findAll().forEach(datacenters::add);
        for(Datacenter dc : datacenters){
            //System.out.println(dc.getDateFabrication().getDay()+ " " +d1.getDay());
            if( (dc.getDateFabrication().getYear()+1900) >=  d1.getYear() && dc.getDateFabrication().getMonth()>=d1.getMonth() ) {
                System.out.println("Region : " + dc.getRegion());
                for(VirtualMachine vm : dc.getVirtualMachines()){
                    System.out.println("Virtual machine : " + vm.getOs());
                }
            }
        }
        return datacenters;
    }
}
