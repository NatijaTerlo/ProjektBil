package org.example.controllers;
import org.example.models.Damage;
import org.example.service.DamageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;


@Controller
public class DamageController {
@Autowired
    DamageService damageService;
    @GetMapping("/all_damages")
    public String showAllDamages(Model model){
        List<Damage>damages = damageService.showAllDamages();
        model.addAttribute("damages", damages);
        return "home/all_damages";
    }

    @GetMapping("/damages")
    public String getDamages(Model model) {
        List<Damage> damages = damageService.getDamages();
        model.addAttribute("damages", damages);
        return "home/damages";
    }
    @GetMapping("/add_damage")
    public String addDamage(){
        return "home/add_damage";
    }
    @PostMapping("/create_damage")
    public String createDamage(@RequestParam int contractId,
                               @RequestParam String description,
                               @RequestParam double price){
        damageService.createDamage(contractId, description, price);
        return "/create_damage";
    }
    @PostMapping("/insert_damage")
    public String insertDamage(@RequestParam int contractId,
                              @RequestParam String description,
                              @RequestParam double price){
        damageService.insertDamage(contractId, description, price);
        return "redirect:/all_damages";
    }
    @PostMapping("/delete_damage")
    public String deleteDamage (@RequestParam int id) {
        damageService.deleteDamage(id);
        return "redirect:/all_damages";
    }
    @GetMapping("/delete_damage")
    public String deleteDamage(@RequestParam int id, Model model){
        Damage damage= damageService.getDamage(id);
        System.out.println(damage);
        model.addAttribute("id", damage.getDamageId());
        model.addAttribute("description", damage.getDescription());
        return "home/delete_damage";
    }
}
