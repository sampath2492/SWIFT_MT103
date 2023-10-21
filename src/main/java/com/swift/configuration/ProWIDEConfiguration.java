package com.swift.configuration;

import com.prowidesoftware.swift.io.parser.SwiftParser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProWIDEConfiguration {

    @Bean
    public SwiftParser swiftParser() {
        return new SwiftParser();
    }
}