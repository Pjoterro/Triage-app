package com.piotrtwardowski.triage.restcontrollers;

import com.piotrtwardowski.triage.services.HelloWorldService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloWorldController {

    private final HelloWorldService helloWorldService;

    @GetMapping(value = "/hello")
    public String hello() {
        return helloWorldService.fetchHelloMessage();
    }
}
