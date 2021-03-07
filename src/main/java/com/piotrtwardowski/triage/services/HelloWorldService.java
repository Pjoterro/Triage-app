package com.piotrtwardowski.triage.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HelloWorldService {

    public String fetchHelloMessage() {
        return "Hello World!";
    }

}
