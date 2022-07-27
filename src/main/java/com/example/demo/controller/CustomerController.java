package com.example.demo.controller;


import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @ResponseBody
    @PostMapping(path = "/customers", produces = "application/json;charset=UTF-8")
    public Object addCustomer(@Valid  @RequestBody Customer cus) {
        Customer result = customerRepository.save(cus);

        return result;
    }

    @ResponseBody
    @DeleteMapping(path = "/customers/{id}", produces = "application/json;charset=UTF-8")
    public ResponseEntity<Object> deleteCustomer(@PathVariable(name = "id") Integer Id) {
        customerRepository.deleteById(Id);

        return null;
    }

    @ResponseBody
    @GetMapping(path = "/customers", produces = "application/json;charset=UTF-8")
    public Object getAllCustomer() {
        List<Customer> result = customerRepository.findAll();

        return result;
    }

    @ResponseBody
    @GetMapping(path = "/customers/{id}", produces = "application/json;charset=UTF-8")
    public Object getCustomer(@PathVariable(name = "id") Integer Id) {
        Optional<Customer> result = customerRepository.findById(Id);

        return result.get();
    }

    @ResponseBody
    @PutMapping (path = "/customers/{id}", produces = "application/json;charset=UTF-8")
    public Object updateCustomer(@PathVariable(name = "id") Integer Id,@RequestBody Customer obj) {
        Optional<Customer> result = customerRepository.findById(Id);
        if(result != null) {
            Customer cus = result.get();
            cus.setName(obj.getName());
            cus.setAge(obj.getAge());
            customerRepository.save(cus);
        }
        return result.get();
    }

    @ResponseBody
    @PatchMapping(path = "/customers/{id}", produces = "application/json;charset=UTF-8")
    public Object patchCustomer(@PathVariable(name = "id") Integer Id,@RequestBody Customer obj) {
        Optional<Customer> result = customerRepository.findById(Id);
        if(result != null) {
            Customer cus = result.get();
            cus.setAge(obj.getAge());
            customerRepository.save(cus);
        }
        return result.get();
    }
}