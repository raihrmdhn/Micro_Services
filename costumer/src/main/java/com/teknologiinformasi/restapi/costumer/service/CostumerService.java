package com.teknologiinformasi.restapi.costumer.service;

import com.teknologiinformasi.restapi.costumer.model.Costumer;
import com.teknologiinformasi.restapi.costumer.repository.CostumerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CostumerService {

    @Autowired
    private CostumerRepository customerRepository;

    // Ambil semua customer
    public List<Costumer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // Ambil customer berdasarkan ID
    public Optional<Costumer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    // Buat customer baru
    public Costumer createCustomer(Costumer customer) {
        return customerRepository.save(customer);
    }

    // Update customer
    public Costumer updateCustomer(Long id, Costumer customerDetails) {
        Costumer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer tidak ditemukan dengan id " + id));
        customer.setName(customerDetails.getName());
        customer.setEmail(customerDetails.getEmail());
        customer.setAddress(customerDetails.getAddress());
        return customerRepository.save(customer);
    }

    // Hapus customer
    public void deleteCustomer(Long id) {
        Costumer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer tidak ditemukan dengan id " + id));
        customerRepository.delete(customer);
    }
}
