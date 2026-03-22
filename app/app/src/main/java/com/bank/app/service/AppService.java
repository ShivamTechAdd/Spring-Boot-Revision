package com.bank.app.service;

import com.bank.app.model.AppModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AppService {
    AppModel getCustomerById(Long id);
    List<AppModel> getAllCustomer();
    AppModel createCustomer(AppModel customer);
    AppModel updateCustomer(AppModel customer, Long id);
    String deleteCustomer(Long id);
}
