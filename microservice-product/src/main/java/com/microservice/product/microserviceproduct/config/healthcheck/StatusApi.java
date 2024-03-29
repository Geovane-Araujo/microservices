package com.microservice.product.microserviceproduct.config.healthcheck;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins="*")
@RequestMapping(value = "/api")
public class StatusApi {


    @GetMapping("/status")
    public ResponseEntity<?> getStatus(){
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("service","PRODUCT");
        response.put("status","up");
        response.put("httpStatus", HttpStatus.OK.value());
        return ResponseEntity.of(Optional.of(response));
    }
}
