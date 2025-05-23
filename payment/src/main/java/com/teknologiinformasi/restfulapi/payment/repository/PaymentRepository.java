package com.teknologiinformasi.restfulapi.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teknologiinformasi.restfulapi.payment.model.Payment;


@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
