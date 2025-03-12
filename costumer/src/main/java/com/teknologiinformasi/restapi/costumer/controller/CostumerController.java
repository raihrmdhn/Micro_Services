package com.teknologiinformasi.restapi.costumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.teknologiinformasi.restapi.costumer.model.Costumer;
import com.teknologiinformasi.restapi.costumer.service.CostumerService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/costumers")
public class CostumerController {

    @Autowired
    private CostumerService customerService;

    // Endpoint untuk mengambil semua customer
    @GetMapping
    public List<Costumer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    // Endpoint untuk mengambil customer berdasarkan id
    @GetMapping("/{id}")
    public ResponseEntity<Costumer> getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id)
                .map(customer -> ResponseEntity.ok().body(customer))
                .orElse(ResponseEntity.notFound().build());
    }

    // Endpoint untuk membuat customer baru
    @PostMapping
    public Costumer createCustomer(@RequestBody Costumer customer) {
        return customerService.createCustomer(customer);
    }

    // Endpoint untuk mengupdate data customer
    @PutMapping("/{id}")
    public ResponseEntity<Costumer> updateCustomer(@PathVariable Long id, @RequestBody Costumer customerDetails) {
        try {
            Costumer updatedCustomer = customerService.updateCustomer(id, customerDetails);
            return ResponseEntity.ok(updatedCustomer);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint untuk menghapus customer
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteCustomer(@PathVariable Long id) {
        try {
            customerService.deleteCustomer(id);
            Map<String, String> response = new HashMap<>();
            response.put("message", "Customer berhasil dihapus");
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Customer tidak ditemukan dengan id " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}
