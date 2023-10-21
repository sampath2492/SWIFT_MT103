package com.swift.service;


public interface MT103Service {
    String generateMT103Message(String sender, String receiver, String amount);
    String parseMT103Message(String message);
}
