package com.codegym.Employee.controller;

import com.codegym.Employee.model.Depart;
import com.codegym.Employee.model.Employee;
import com.codegym.Employee.service.DepartService;
import com.codegym.Employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.Optional;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartService departService;
    @GetMapping("/")
    public ModelAndView showListEmployee(@PageableDefault(value = 3) Pageable pageable, @RequestParam("name")Optional<String> name,
                                         @RequestParam("depart")Optional<Depart> depart){
        Page<Employee> employees;
        if(name.isPresent()){
            employees = employeeService.findAllByNameContainingOrCodeContaining(name.get(),name.get(),pageable);
        }else {
            employees = employeeService.findAll(pageable);
        }
        if(depart.isPresent()){
            employees = employeeService.findAllByDepart(depart.get(),pageable);
        }
        return new ModelAndView("list","employees",employees);
    }
    @GetMapping("/create-employee")
    public ModelAndView showCreateForm(){
        return new ModelAndView("create","employee",new Employee());
    }
    @PostMapping("/create-employee")
    public String CreateEmployee(Employee employee, RedirectAttributes redirect){
        redirect.addFlashAttribute("message","Create success");
        employeeService.save(employee);
        return "redirect:/";
    }
    @GetMapping("/edit-employee/{id}")
    public ModelAndView showEditForm(@PathVariable int id){
        return new ModelAndView("edit","employee",employeeService.findById(id));
    }
    @PostMapping("/edit-employee")
    public String EditEmployee(Employee employee,RedirectAttributes redirect){
        redirect.addFlashAttribute("message","Edit success");
        employeeService.save(employee);
        return "redirect:/";
    }
    @GetMapping("/delete-employee/{id}")
    public String DeleteEmployee(@PathVariable int id,RedirectAttributes redirect){
        redirect.addFlashAttribute("message","Delete success");
        employeeService.remove(employeeService.findById(id));
        return "redirect:/";
    }
    @ModelAttribute("departs")
    public Page<Depart> ListDepart(Pageable pageable){
        return departService.findAll(pageable);
    }

    @GetMapping("/view-employee/{id}")
    public ModelAndView showViewForm(@PathVariable int id){
        return new ModelAndView("view","employee",employeeService.findById(id));
    }
}
