package org.example.controllers;
import org.example.models.Contract;
import org.example.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;


@Controller
public class ContractController {
    @Autowired
    private ContractService contractService;

    @GetMapping("/all_contracts")
    public String showAllContracts(Model model){
        List<Contract> contracts = contractService.showAllContracts();
        model.addAttribute("contracts",contracts);
        return "home/all_contracts";
    }
    @GetMapping("/add_contract")
    public String addContract(){
        return "home/add_contract";
    }
    @PostMapping("/create_contract")
    public String createContract(@RequestParam int customerId,
                         @RequestParam int carId,
                         @RequestParam ("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                         @RequestParam ("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate,
                         @RequestParam double totalPrice) {
        contractService.createContract(customerId, carId, startDate, endDate, totalPrice);
        return "/create_contract";
    }

    @PostMapping("/insert_contract")
    public String insertContract (@RequestParam int customerId,
                                  @RequestParam int carId,
                                  @RequestParam ("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                                  @RequestParam ("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate,
                                  @RequestParam double totalPrice) {
        contractService.insertContract(customerId, carId, startDate, endDate, totalPrice);
        return "redirect:/all_contracts";
    }

    @PostMapping("/delete_contract")
    public String deleteContract (@RequestParam int id){
       contractService.deleteContract(id);
        return "redirect:/all_contracts";
    }

    @GetMapping("/delete_contract")
    public String deleteContract(@RequestParam int id, Model model){
        Contract contract = contractService.getContract(id);
        System.out.println(contract);
        model.addAttribute("id", contract.getContractId());
        model.addAttribute("contractId", contract.getContractId());
        model.addAttribute("carId", contract.getCarId());
        return "home/delete_contract";
    }

}
