package com.bank.app.controller;

import com.bank.app.model.AppModel;
import com.bank.app.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AppController {
    @Autowired
    private AppService appService;

    @GetMapping("/public/customers/{id}")
    public ResponseEntity<AppModel> getById(@PathVariable Long id){
        AppModel customer = appService.getCustomerById(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @GetMapping("/public/customers")
    public ResponseEntity<List<AppModel>> getAllCustomer(){
        List<AppModel> customer = appService.getAllCustomer();
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PostMapping("/public/customers")
    public ResponseEntity<AppModel> createCustomer(@RequestBody AppModel customer){
        AppModel createdCustomer = appService.createCustomer(customer);
        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
    }

    @PutMapping("/admin/customers/{id}")
    public ResponseEntity<AppModel> updateCustomer(@RequestBody AppModel customer , @PathVariable Long id){
        AppModel updatedCustomer = appService.updateCustomer(customer,id);
        return new ResponseEntity<>(updatedCustomer, HttpStatus.CREATED);
    }

    @DeleteMapping("/admin/customers/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id){
        String status = appService.deleteCustomer(id);
        return new ResponseEntity<>(status, HttpStatus.CREATED);
    }

}
