package com.ibagroup.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/basic")
public class BasicController {
    @GetMapping
    public List<String> getAll(){
        List<String> result = new ArrayList<>();
        result.add("Jane Dubinina");
        result.add("Kiryl Aleksandrovich");
        return result;
    }
}
