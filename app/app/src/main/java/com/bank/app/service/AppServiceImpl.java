package com.bank.app.service;

import com.bank.app.model.AppModel;
import com.bank.app.repository.AppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AppServiceImpl implements AppService{
    @Autowired
    private AppRepository appRepository;

    @Override
    public AppModel getCustomerById(Long id) {
        return appRepository.findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"No Customer present with this id "+ id));
    }

    @Override
    public List<AppModel> getAllCustomer() {
        return appRepository.findAll();
    }

    @Override
    public AppModel createCustomer(AppModel customer) {
        return appRepository.save(customer);
    }

    @Override
    public AppModel updateCustomer(AppModel customer, Long id) {
        AppModel savedCustomer = appRepository.findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"No Customer present with this id "+ id));
        savedCustomer.setFirstName(customer.getFirstName());
        savedCustomer.setLastName(customer.getLastName());
        savedCustomer.setEmail(customer.getEmail());
        savedCustomer.setPhoneNo(customer.getPhoneNo());
        AppModel updatedCustomer = appRepository.save(savedCustomer);
        return updatedCustomer;
    }

    @Override
    public String deleteCustomer(Long id) {
        AppModel savedCustomer = appRepository.findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"No Customer present with this id "+ id));
        appRepository.delete(savedCustomer);
        return "Customer Deleted Successfully";
    }

}
