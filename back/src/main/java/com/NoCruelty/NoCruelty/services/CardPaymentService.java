package com.NoCruelty.NoCruelty.services;

import com.NoCruelty.NoCruelty.DTO.CardPaymentDTO;
import com.NoCruelty.NoCruelty.DTO.PayerDTO;
import com.NoCruelty.NoCruelty.DTO.PaymentResponseDTO;
import com.NoCruelty.NoCruelty.repositories.PaymentRepository;
import com.NoCruelty.NoCruelty.models.Payment;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CardPaymentService {
//    @Value("${mercado_pago_sample_access_token}")
//    private String mercadoPagoAccessToken;
//
    PaymentRepository paymentRepository;
//    
//    public PaymentResponseDTO processPayment(CardPaymentDTO cardPaymentDTO) {
//        try {
//            MercadoPago.SDK.setAccessToken(mercadoPagoAccessToken);
//
//            Payment payment = new Payment();
//            payment.setTransactionAmount(cardPaymentDTO.getTransactionAmount())
//                    .setToken(cardPaymentDTO.getToken())
//                    .setDescription(cardPaymentDTO.getProductDescription())
//                    .setInstallments(cardPaymentDTO.getInstallments())
//                    .setPaymentMethodId(cardPaymentDTO.getPaymentMethodId());
//
//            Identification identification = new Identification();
//            identification.setType(cardPaymentDTO.getPayer().getIdentification().getType())
//                    .setNumber(cardPaymentDTO.getPayer().getIdentification().getNumber());
//
//            Payer payer = new Payer();
//            payer.setEmail(cardPaymentDTO.getPayer().getEmail());
//            payer.setIdentification(identification);
//
//            payment.setPayer(payer);
//
//            Payment createdPayment = payment.save();
//
//            this.validatePaymentResult(createdPayment);
//
//            PaymentResponseDTO paymentResponseDTO = new PaymentResponseDTO(
//                    createdPayment.getId(),
//                    String.valueOf(createdPayment.getStatus()),
//                    createdPayment.getStatusDetail()
//            );
//
//            return paymentResponseDTO;
//        } catch (MPException exception) {
//            System.out.println(exception.getMessage());
//            throw new MercadoPagoException(exception.getMessage());
//        }
//    }
//
//    private void validatePaymentResult(Payment createdPayment) throws MPException {
//        if(createdPayment.getId() == null) {
//            String errorMessage = "Unknown error cause";
//
//            if(createdPayment.getLastApiResponse() != null) {
//                String sdkErrorMessage = createdPayment.getLastApiResponse().getJsonElementResponse().getAsJsonObject().get("message").getAsString();
//                errorMessage = sdkErrorMessage != null ? sdkErrorMessage : errorMessage;
//            }
//
//            throw new MPException(errorMessage);
//        }
//    }

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
        if (cardNumber == null || cardNumber.isEmpty() || cardNumber.contains("   ") || cardNumber.length() < 16 || cardNumber.length() > 16) {
            throw new Error("The card number must not contain spaces, be empty or differ from 16 digits.");
        }
        if (securityCode == null || securityCode.isEmpty() || securityCode.contains("   ") || securityCode.length() < 4 || securityCode.length() > 4) {
            throw new Error("The security card number must not contain spaces, be empty or differ from 4 digits.");
        }
        if (DNI == null || DNI.isEmpty() || DNI.contains("   ") || DNI.length() < 8 || DNI.length() > 8) {
            throw new Error("The DNI must not contain spaces, be empty or differ from 8 digits.");
        }
        if (expireDate == null || expireDate.isEmpty() || expireDate.contains("   ")) {
            throw new Error("Dates must not contain spaces or be empty.");
        }
        if (responsible == null || responsible.isEmpty() || responsible.contains("   ") || responsible.length() < 4) {
            throw new Error("Responsible's name must not contain spaces, be empty or be less than 3 letters.");
        }
    }
}
