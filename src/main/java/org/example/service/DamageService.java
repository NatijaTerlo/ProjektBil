package org.example.service;
import org.example.models.Damage;
import org.example.repository.DamageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DamageService {
    @Autowired
     private DamageRepository damageRepository;

    public List<Damage> showAllDamages(){
        return damageRepository.showAllDamages();
    }

    public List<Damage>getDamages(){
        return damageRepository.getDamages();
    }
    public void createDamage(int contractId, String description, double price){
        damageRepository.createDamage(contractId, description, price);
    }
    public void insertDamage(int contractId, String description, double price){
      damageRepository.insertDamage(contractId, description, price);
    }
    public void deleteDamage(int id){
        damageRepository.deleteDamage(id);
    }
    public Damage getDamage(int id){
        return damageRepository.getDamage(id);
    }
}
