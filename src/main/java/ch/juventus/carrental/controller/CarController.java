package ch.juventus.carrental.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {
    @GetMapping("/api/v1/helloWorld")
    public ResponseEntity<String> helloworld() {
        String response = "hello world";
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
