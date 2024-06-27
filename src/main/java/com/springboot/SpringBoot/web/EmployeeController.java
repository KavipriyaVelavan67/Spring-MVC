package com.springboot.SpringBoot.web;

import com.springboot.SpringBoot.model.Employee;
import com.springboot.SpringBoot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

   /* @Autowired
    EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }*/

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("allemplist", employeeService.getAllEmployee());
        return "index";
    }

    @GetMapping("/addnew")
   // @RequestMapping(value = "/", method = RequestMethod.GET)
    public String addNewEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "newemployee";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.save(employee);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String updateForm(@PathVariable(value = "id") long id, Model model) {
        Employee employee = employeeService.getById(id);
        model.addAttribute("employee", employee);
        return "update";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable(value = "id") long id) {
        // Call the service to delete the employee
        employeeService.deleteViaId(id);
        return "redirect:/";  // Redirect to the home page after deletion
    }

    @ResponseBody
    @GetMapping("/rest")
    public List<Employee> getEmployeeRest() {
        return employeeService.getAllEmployee();
    }



}
