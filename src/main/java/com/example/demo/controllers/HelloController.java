package com.example.demo.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import difexamples.ClientComponent;
import org.springframework.beans.factory.ObjectProvider;

@RestController
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class HelloController {

    private final ClientComponent clientComponent;
    private final ObjectProvider<ClientComponent> clientProvider;

    @GetMapping("/")
    public String hello() {
        return "Hello from Spring Boot";
    }

    @GetMapping("/client")
    public String client() {
        return "Hello from ClientComponent = " + clientComponent;
    }

    @GetMapping("/client-multiple")
    public String multipleClients() {
        ClientComponent c1 = clientProvider.getObject();
        ClientComponent c2 = clientProvider.getObject();
        return "c1 = " + c1 + ", c2 = " + c2;
    }
}
