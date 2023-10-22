package dev.miage.inf2.course.cdi.service.impl;

import com.twilio.Twilio;
import com.twilio.type.PhoneNumber;
import com.twilio.rest.api.v2010.account.Message;
import dev.miage.inf2.course.cdi.model.CustomerDTO;
import dev.miage.inf2.course.cdi.model.ReceiptDTO;
import dev.miage.inf2.course.cdi.service.ReceiptTransmissionService;
import jakarta.enterprise.context.Dependent;

@Dependent
public class ReceiptTransmissionServiceSMS<T> implements ReceiptTransmissionService<T> {


    public static final String ACCOUNT_SID = "ACXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
    public static final String AUTH_TOKEN = "your_auth_token";


    @Override
    public void sendReceipt(CustomerDTO customer, ReceiptDTO<T> receipt) {

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(new PhoneNumber(customer.phoneNumber()), new PhoneNumber("ANON"), "Merci de votre achat d'un montant de " + receipt.price() + " pour " + receipt.item().toString()).create();


    }
}
