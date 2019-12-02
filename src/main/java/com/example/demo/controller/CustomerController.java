package com.example.demo.controller;


import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @ResponseBody
    @PostMapping(path = "/customer", produces = "application/json;charset=UTF-8")
    public ResponseEntity<Object> addCustomer(@RequestBody Customer cus) {
        Customer result = customerRepository.save(cus);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ResponseBody
    @DeleteMapping(path = "/customer", produces = "application/json;charset=UTF-8")
    public ResponseEntity<Object> deleteCustomer(Integer Id) {
        customerRepository.deleteById(Id);

        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @ResponseBody
    @GetMapping(path = "/customer", produces = "application/json;charset=UTF-8")
    public ResponseEntity<Object> getAllCustomer() {
        List<Customer> result = customerRepository.findAll();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping(path = "/customer/{id}", produces = "application/json;charset=UTF-8")
    public ResponseEntity<Object> getCustomer(@PathVariable(name = "id") Integer Id) {
        Optional<Customer> result = customerRepository.findById(Id);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ResponseBody
    @PutMapping (path = "/customer/{id}", produces = "application/json;charset=UTF-8")
    public ResponseEntity<Object> updateCustomer(@PathVariable(name = "id") Integer Id,@RequestBody Customer obj) {
        Optional<Customer> result = customerRepository.findById(Id);
        if(result != null) {
            Customer cus = result.get();
            cus.setName(obj.getName());
            cus.setAge(obj.getAge());
            customerRepository.save(cus);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ResponseBody
    @PatchMapping(path = "/customer/{id}", produces = "application/json;charset=UTF-8")
    public ResponseEntity<Object> patchCustomer(@PathVariable(name = "id") Integer Id,@RequestBody int age) {
        Optional<Customer> result = customerRepository.findById(Id);
        if(result != null) {
            Customer cus = result.get();
            cus.setAge(age);
            customerRepository.save(cus);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}