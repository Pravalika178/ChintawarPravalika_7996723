package com.example.ems.controller;

import com.example.ems.entity.Employee;
import com.example.ems.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import main.java.com.example.ems.projection.EmployeeView;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService service;

    @PostMapping
    public Employee save(@RequestBody Employee e){
        return service.save(e);
    }

    @GetMapping
    public List<Employee> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Employee get(@PathVariable Long id){
        return service.get(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

    @GetMapping("/projection")
    public List<EmployeeView> getEmployeesProjection() {
    return employeeRepository.findAllProjectedBy();
    }
    @GetMapping("/page")
        public Page<Employee> getEmployees(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "5") int size,
        @RequestParam(defaultValue = "id") String sortBy) {

    Pageable pageable =
            PageRequest.of(page, size,
                    Sort.by(sortBy));

    return employeeRepository.findAll(pageable);
}
}