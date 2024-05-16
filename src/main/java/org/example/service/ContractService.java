package org.example.service;
import org.example.models.Contract;
import org.example.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class ContractService {
    @Autowired

    private ContractRepository contractRepository;

    public void createContract(int customerId, int carId, Date startDate, Date endDate, double totalPrice){
       contractRepository.createContract(customerId, carId, startDate, endDate, totalPrice);
    }
    public void deleteContract(int id){
        contractRepository.deleteContract(id);
    }

    public Contract getContract(int id) {
        return contractRepository.getContract(id);
    }

    public List<Contract> showAllContracts() {
        return contractRepository.showAllContracts();
    }

    public void insertContract(int customerId, int carId, Date startDate, Date endDate, double totalPrice) {
      contractRepository.insertContract(customerId, carId, startDate, endDate, totalPrice);
    }
}
