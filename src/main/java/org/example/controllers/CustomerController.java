package org.example.controllers;
import org.example.models.Customer;
import org.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/all_customers")
    public String showAllCustomers(Model model){
        List<Customer>customers = customerService.showAllCustomers();
        model.addAttribute("customers", customers);
        return "home/all_customers";
    }
    @GetMapping("/customers")
    public String getCustomers(Model model){
        List<Customer> customers = customerService.getCustomers();
        model.addAttribute("customers", customers);
        return "home/customers";
    }
    @GetMapping("/add_customer")
    public String addCustomer(){
        return "home/add_customer";
    }

    @PostMapping("/create_customer")
    public String createCustomer(@RequestParam String firstName,
                                 @RequestParam String lastName,
                                 @RequestParam String email,
                                 @RequestParam int phone,
                                 @RequestParam String address,  Model model) {
        customerService.createCustomer(firstName, lastName, email, phone,address);
        return "/create_customer";
    }
   /* @GetMapping("/{id}/new_customer")
    public String newCustomer(@PathVariable("id") int customerId, Model model){
        Customer customers= new Customer();
        customers.setCustomerID(customerId);
        model.addAttribute("customers", customers);
        return "home/new_customer";
    }

    */
    @PostMapping("/insert_customer")
    public String insertCustomer (@RequestParam String firstName,
                                  @RequestParam String lastName,
                                  @RequestParam String email,
                                  @RequestParam int phone,
                                  @RequestParam String address) {
        customerService.insertCustomer(firstName, lastName, email, phone, address);
        return "redirect:/all_customers";
    }

    @PostMapping("/delete_customer")
    public String deleteCustomer (@RequestParam int id) {
        customerService.deleteCustomer(id);
            return "redirect:/all_customers";
        }
    @GetMapping("/delete_customer")
    public String deleteCustomer(@RequestParam int id, Model model){
        Customer customer=customerService.getCustomer(id);
        System.out.println(customer);
        model.addAttribute("id", customer.getCustomerId());
        model.addAttribute("firstName", customer.getFirstName());
        model.addAttribute("lastName", customer.getLastName());
        return "home/delete_customer";
    }

}
