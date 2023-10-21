package com.swift.service.impl;

import com.prowidesoftware.swift.io.parser.SwiftParser;
import com.prowidesoftware.swift.model.SwiftMessage;
import com.prowidesoftware.swift.model.field.*;
import com.prowidesoftware.swift.model.mt.mt1xx.MT103;
import com.swift.service.MT103Service;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
@RequiredArgsConstructor
public class MT103ServiceImpl implements MT103Service {

    @Autowired
    private SwiftParser swiftParser;

    @Override
    public String generateMT103Message(String sender, String receiver, String amount) {
        try {
            MT103 m = new MT103();

            m.setSender(sender);
            m.setReceiver(receiver);

            /*
             * Start adding the message's fields in correct order
             */
            m.addField(new Field20("REFERENCE"));
            m.addField(new Field23B("CRED"));

            /*
             * Add a field using comprehensive setters API
             */
            Field32A f32A = new Field32A()
                    .setDate(Calendar.getInstance())
                    .setCurrency("INR")
                    .setAmount(amount);
            m.addField(f32A);

            /*
             * Add the orderer field
             */
            Field50A f50A = new Field50A()
                    .setAccount("12345678901234567890")
                    .setBIC("HDFCINDXXXXX");
            m.addField(f50A);

            /*
             * Add the beneficiary field
             */
            Field59 f59 = new Field59()
                    .setAccount("12345678901234567890")
                    .setNameAndAddress("Sampath J");
            m.addField(f59);

            /*
             * Add the commission indication
             */
            m.addField(new Field71A("OUR"));

            /*
             * Create and print out the SWIFT FIN message string
             */
            System.out.println("Message Starts->:" + m.message() + "<-- message Ends");
            return m.message();
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String parseMT103Message(String message) {
        try {
            MT103 msg = MT103.parse(message);
            return "Sender:"+msg.getSender()+"; receiver:"+msg.getReceiver()+"; amount:"+msg.getField32A().amount();
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
