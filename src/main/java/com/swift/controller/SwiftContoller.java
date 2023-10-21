package com.swift.controller;

import com.swift.constants.Constants;
import com.swift.service.MT103Service;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Constants.SWIFT)
@RequiredArgsConstructor
public class SwiftContoller {
    @Autowired
    private MT103Service mt103Service;

    @GetMapping(Constants.MT103)
    public String generateMT103Message(String sender, String receiver, String amount){
        return mt103Service.generateMT103Message(sender, receiver, amount);
    }

    @GetMapping(Constants.MT103SAMPLE)
    public String generateMT103SampleMessage(){
        return mt103Service.generateMT103Message("SAMPATH", "SANTHOSH", "100000");
    }

    @GetMapping(Constants.MT103PARSE)
    public String ParseMT103Message(@RequestBody String message){
        return mt103Service.parseMT103Message(message);
    }
}
