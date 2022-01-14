package com.NoCruelty.NoCruelty.services;

import com.NoCruelty.NoCruelty.repositories.PaymentRepository;
import com.NoCruelty.NoCruelty.models.Payment;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    // crud > create, read, update, delete
    
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public Payment create(String cardNumber, String securityCode, String DNI, String expireDate, String responsible) throws Exception {
        validate(cardNumber, securityCode, DNI, expireDate, responsible);
        Payment payment = new Payment();
        payment.setCardNumber(cardNumber);
        payment.setSecurityCode(securityCode);
        payment.setDNI(DNI);
        payment.setExpireDate(expireDate);
        payment.setResponsible(responsible);
        return paymentRepository.save(payment);
    }

    @Transactional(readOnly = true)
    public List<Payment> read() {
        return paymentRepository.findAll();
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public Payment update(Long id, String cardNumber, String securityCode, String DNI, String expireDate, String responsible) throws Exception {
        validate(cardNumber, securityCode, DNI, expireDate, responsible);
        Optional<Payment> answer = paymentRepository.findById(id);
        if (answer.isPresent()) {
            Payment payment = paymentRepository.findById(id).get();
            payment.setCardNumber(cardNumber);
            payment.setSecurityCode(securityCode);
            payment.setDNI(DNI);
            payment.setExpireDate(expireDate);
            payment.setResponsible(responsible);
            return paymentRepository.save(payment);
        } else {
            throw new Error("No se encontro el pago realizado");
        }
    }

    public void delete(Long id) {
        Optional<Payment> answer = paymentRepository.findById(id);
        if (answer.isPresent()) {
            Payment payment = answer.get();
            paymentRepository.delete(payment);
        }
    }

    @Transactional
    private void validate(String cardNumber, String securityCode, String DNI, String expireDate, String responsible) throws Error {
        if (cardNumber == null || cardNumber.isEmpty() || cardNumber.isBlank() || cardNumber.length() < 16 || cardNumber.length() > 16) {
            throw new Error("The card number must not contain spaces, be empty or differ from 16 digits.");
        }
        if (securityCode == null || securityCode.isEmpty() || securityCode.isBlank() || securityCode.length() < 4 || securityCode.length() > 4) {
            throw new Error("The security card number must not contain spaces, be empty or differ from 4 digits.");
        }
        if (DNI == null || DNI.isEmpty() || DNI.isBlank() || DNI.length() < 8 || DNI.length() > 8) {
            throw new Error("The DNI must not contain spaces, be empty or differ from 8 digits.");
        }
        if (expireDate == null || expireDate.isEmpty() || expireDate.isBlank()) {
            throw new Error("Dates must not contain spaces or be empty.");
        }
        if (responsible == null || responsible.isEmpty() || responsible.isBlank() || responsible.length() < 4) {
            throw new Error("Responsible's name must not contain spaces, be empty or be less than 3 letters.");
        }
    }
}
