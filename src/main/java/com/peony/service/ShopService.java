package com.peony.service;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ShopService {

    @PostMapping("/search")
    public String search(@RequestBody Map<String, String> body){
        return body.toString();
    }

}
