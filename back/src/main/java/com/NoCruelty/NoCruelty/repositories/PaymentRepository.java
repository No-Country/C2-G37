package com.NoCruelty.NoCruelty.repositories;

import org.springframework.stereotype.Repository;
import com.NoCruelty.NoCruelty.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    
}
